package common.commands;

import App.Country;
import App.Person;
import common.*;
import utility.ServerMain;
import utility.ServerSender;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Collections;

/**
 * Команда "Вывести вле элементы определённой национальности"
 */
public class Filter_by_nationality implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    /**
     * Метод "выполнить"
     */
    @Override
    public void execute(String s) {
        if (s == null || s.equals("")) {
            ServerSender.send("строка пустая", 0);
            return;
        }
        if (Country.getValue(s) == null) {
            ServerSender.send("такого типа нет братик", 0);
            return;
        }
        if (ServerMain.c.people.size() == 0) {
            System.out.println("Коллекция пуста, милорд");
        } else {
            for (Person r : ServerMain.c.people) {
                if(r.getNationality().str.equals(s))
                    ServerSender.send("  " + r.toString(), 0);
            }
//            ServerSender.send("готово", 0);
        }
    }


    @Override
    public String getInfo() {
        return "filter_by_nationality : вывести элементы, значения поля nationality которых равно заданному";
    }

}
