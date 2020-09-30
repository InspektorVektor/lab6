package common.commands;

import common.*;
import Readers.*;
import App.Person;
import utility.ServerMain;
import utility.ServerSender;

/**
 * Команда "УДОЛИ!"
 */
public class Remove_greater implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    /**
     * метод удаления элемента коллекции по его id
     */
    @Override
    public void execute(String s) {
        if (s==null || s.equals("")) {
            ServerSender.send("рост введи", 0);
            return;
        }
        double height;
        try { height = Checker.doubleChecker(s); }
        catch (NullPointerException e) {
            ServerSender.send("должно быть дабл", 0);
            return;
        }
        if (!(height > 0)) {
            ServerSender.send("должно быть больше 0", 0);
            return;
        }


        if (ServerMain.c.people.size() > 0) {
            for (Person r: ServerMain.c.people) {
                if (r.getHeight() > height) {
                    ServerMain.c.people.remove(r);
                }
            }
            ServerSender.send("Элемент успешно удалён из коллекции. Вот.", 0);

        } else
            ServerSender.send("пусто", 0);
    }

    @Override
    public String getInfo() {
        return "remove_greater : удалить элемент из коллекции по его id";
    }

}