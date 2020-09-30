package utility;

import XmlManagers.XmlReader;
import common.*;
import common.commands.*;
import App.Collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketAddress;
import java.util.Map;
import Readers.*;
import sun.misc.Signal;

/**
 * Главненький
 */
public class ServerMain {






    public static Collection c = null;
    public static Integer port;
    public static SocketAddress clientAdderss;
    /**
     * psvm
     *
     * @param args аргументики
     * @throws IOException
     */
    public static void main(String[] args) {
        Signal.handle(new Signal("INT"), sig ->  {
            System.out.println("\n" + "Контрлцешное завершение программы");
            System.exit(0);
        });

        Add add = new Add();
        Add_if_max add_if_max = new Add_if_max();
        Clear clear = new Clear();
        Exit exit = new Exit();
        Info info = new Info();
        Max_by_height max_byDistance = new Max_by_height();
        Filter_by_nationality filter_by_nationality = new Filter_by_nationality();
        Filter_greater_than_birthday filter_greater_than_birthday = new Filter_greater_than_birthday();
        Remove_by_id remove_byId = new Remove_by_id();
        Remove_greater remove_greater = new Remove_greater();
        Show show = new Show();
        Save save = new Save();
        Updater update = new Updater();
      //  CreateServer.create();
       // System.out.println("Сервер запущен.");
       ConsoleSourceReader bufferReader = new ConsoleSourceReader();
        String path = null;

        try {
            path = args[0];
            c = XmlReader.getCollection(path);
        } catch (ArrayIndexOutOfBoundsException | FileNotFoundException ignored) {
        }
        while (c == null) {
            System.out.println("Введите расположение файла с коллекцией или нажмите Enter, чтобы начать работу с дефолтной коллекцией: ");
            path = bufferReader.getLine() + "";
            if (path.equals("")) {
                path = "resources/input.xml";
                System.out.println("Вы начали работу с коллекцией по умолчанию. Если хотите увидеть ее элементы, введите \"show\"");
            }

            try {
                c = XmlReader.getCollection(path);
            } catch (FileNotFoundException ignored) {
            }

        }

        try {
            if (new File(path).exists()) {
                c.setPath(path);
            }
        } catch (NullPointerException ignored) {
        }


//           c = new Collection(); // !!!!
        boolean serverCreated = false;
        while (!serverCreated) {
            System.out.print("Введите порт:  ");

            try {
                port = Integer.parseInt(bufferReader.getLine());
            } catch (NumberFormatException e){
                System.out.println("Формат неправильный");
                continue;
            }
            serverCreated = CreateServer.create();
        }
        System.out.println("Советик: введите help, чтобы увидеть доступные команды.");
        InputString inputString = new InputString();
        inputString.start();
        while (true) {
            GetCommand();
        }
    }

    public static void GetCommand() {
        Map<Command, String> commandStringMap;
        try {
            System.out.println("\nЖду команду от клиента.");
            Object o = ByteToObject.Cast(ServerReceiver.receive());
            commandStringMap = (Map<Command, String>) o;
            CreateServer.serverIsAvaible = false;
            System.out.println("\nВыполняю команду " + commandStringMap.entrySet().iterator().next().getKey().getClass().getName());
            commandStringMap.entrySet().iterator().next().getKey().execute(commandStringMap.entrySet().iterator().next().getValue());
            CreateServer.serverIsAvaible = true;
            if (!commandStringMap.entrySet().iterator().next().getKey().getClass().getName().equals("Common.Commands.Exit"))
                System.out.println("\nКоманда выполнена! Отправляю результат клиенту.");
        } catch (ClassCastException e) {
            ServerSender.send("\nСообщение от Сервера:\"Возникли небольшие неполадки с вашим подключением,но сейчас всё по кайфу,ожидаю команд.\"\n", 0);
        }
    }
}

