package common.commands;

import common.*;
import Readers.*;
import App.Person;
import utility.ServerMain;
import utility.ServerSender;

/**
 * Команда "УДОЛИ!"
 */
public class Remove_by_id implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    /**
     * метод удаления элемента коллекции по его id
     */
    @Override
    public void execute(String s) {
        if (s == null || s.equals("")) {
            ServerSender.send("пустая строка", 0);
            return;
        }
        int removeId = Checker.intChecker(s);
        Person r = ServerMain.c.searchById(removeId);
        if (r == null) {
            ServerSender.send("нет такого", 0);
            return;
        }
        ServerMain.c.people.remove(r);
        ServerSender.send("Элемент успешно удалён из коллекции. Вот.", 0);
    }

    @Override
    public String getInfo() {
        return "remove_by_id id : удалить элемент из коллекции по его id";
    }

}
