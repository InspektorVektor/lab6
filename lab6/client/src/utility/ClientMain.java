package utility;

import common.Invoker;
import common.Command;
import common.commands.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Map;

/**
 * Главненький
 */
public class ClientMain {

    public static boolean work = true; // переменная, отвечающая за выход из программы. Как только она станет false, программа завершается
    public static BufferedReader reader = null;
    public static int port;
    public static InetAddress address;


    /**
     * psvm
     *
     * @param args аргументики
     */
    public static void main(String[] args) {
//        Signal.handle(new Signal("INT"), sig ->  {
//            System.out.println("\n" + "Контрлцешное завершение программы");
//            System.exit(0);
//        });
        Add add = new Add();
        Add_if_max add_if_max = new Add_if_max();
        Clear clear = new Clear();
        Execute_script execute_script = new Execute_script();
        Exit exit = new Exit();
        Filter_by_nationality filter_by_nationality = new Filter_by_nationality();
        Filter_greater_than_birthday filter_greater_than_birthday = new Filter_greater_than_birthday();
        Help help = new Help();
        History history = new History();
        Info info = new Info();
        Max_by_height max_by_height = new Max_by_height();
        Remove_by_id remove_by_id = new Remove_by_id();
        Remove_greater remove_greater = new Remove_greater();
        Show show = new Show();
        Updater updater = new Updater();

        reader = new BufferedReader(new InputStreamReader(System.in));

        boolean hasAdderss = false;
        while (!hasAdderss) {
            System.out.print("Введите адрес сервера (нажмите энтер, если приложение запущено на сервере):  ");
            try {
                String s = reader.readLine().trim();
                if (s.equals("") | s == null) {
                    address = InetAddress.getLocalHost();
                } else {
                    if(s.trim().toLowerCase().equals("localhost"))
                        address = InetAddress.getLocalHost();
                    else address = InetAddress.getByName(s);

                }
            } catch (UnknownHostException e) {
                System.out.println("Невозможно найти сервер с таким адресом");
                System.exit(0);
            } catch (IOException e) {
                System.out.println("Ошибка ввода");
                continue;
            }
            try {
                if (!address.isReachable(2500)) {
                    System.out.println("Невозможно достучаться до сервера");
                    continue;
                }
            } catch (IOException e) {
                System.out.println("Ошибка ввода.");
                continue;
            }
            hasAdderss = true;


            boolean hasPort = false;
            while (!hasPort) {
                System.out.print("Введите порт:  ");
                try {
                    port = Integer.parseInt(reader.readLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Формат неправильный");
                    continue;
                } catch (IOException e) {
                    System.out.println("Ошибка ввода");
                    continue;
                }
                hasPort = true;
            }

            try {
                DatagramSocket ds = new DatagramSocket();
                ClientReceiver.sock = ds;
                ClientReceiver.clientport = ds.getLocalPort();
            } catch (SocketException e) {
                System.out.println("Ошибка подключения. Завершение программы.");
                System.exit(0);

            }
            while (work) {
                Map<Command, String> commandparamMap = null;
                System.out.print("Введите команду:  ");
                try {
                    String s = reader.readLine();
                    commandparamMap = Invoker.execute(s);
                } catch (IOException e) {
                    System.out.println("Ошибка ввода");
                    continue;
                }
                if (commandparamMap != null) {
                    ClientSender.send(commandparamMap);
                    try {
                        ClientReceiver.receive();
                    } catch (SocketTimeoutException e) {
                        System.out.println("Сервер не отвечает или занят,попробуйте ещё раз и убедитесь,что сервер работает.");
                    }
                }
            }
        }
    }
}


