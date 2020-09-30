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
 * Команда "Вывести старых"
 */
public class Filter_greater_than_birthday implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    /**
     * Метод для вывода всех элементов, значения поля birthday которых больше заданного
     */

    @Override
    public void execute(String s) {
        if ( s==null || s.equals("")) {
            ServerSender.send("пустоая строка", 0);
            return;
        }
        LocalDateTime localDateTime;
        try {
            localDateTime = LocalDateTime.parse(s);
        } catch (DateTimeParseException e){
            ServerSender.send("формат не тот", 0);
            return;
        }
        if (ServerMain.c.people.size() == 0) {
            ServerSender.send("пусто", 0);
        } else {
            for (Person r : ServerMain.c.people) {
                if(r.getBirthday().isAfter(localDateTime))
                    ServerSender.send("  " + r.toString(), 0);
            }
//            ServerSender.send("готово сынок", 0);
        }
    }

    @Override
    public String getInfo() {
        return "filter_greater_than_birthday : вывести элементы, значения поля birthday которых больше заданного";
    }

}

