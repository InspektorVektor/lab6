package common.commands;
import common.*;
import App.Person;
import utility.ServerMain;
import utility.ServerSender;
/**
 * Команда "МАКСИМАЛЬНЫЙ"
 */
public class Max_by_height implements Command {
        private static final long serialVersionUID = 6529685098267757690L;

        /**
         * метод для вывода любого объект из коллекции, значение поля height которого является максимальным
         */
        @Override
        public synchronized void execute(String s) {
                if (ServerMain.c.people.size() > 0) {
                        double[] d = {0, 0};
                        Person maxPersonByHeight = ServerMain.c.people.stream()
                                .max((p1, p2) -> {
                                        if (p1.getHeight() == null) d[0] = 0;
                                        else d[0] = p1.getHeight();
                                        if (p2.getHeight() == null) d[1] = 0;
                                        else d[1] = p2.getHeight();
                                        return Double.compare(d[0], d[1]);
                                })
                                .get();
                        ServerSender.send("\n \n" + maxPersonByHeight + "\n \n", 0);
                } else
                        ServerSender.send("\nКоллекция пуста как моё сердце \n \n", 0);
        }
        @Override
        public String getInfo() {
                return "max_by_height: вывести любой объект из коллекции, значение поля height которого является максимальным";
        }
}