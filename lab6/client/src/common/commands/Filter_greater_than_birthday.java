package common.commands;

import common.*;

/**
 * Команда "Вывести старых"
 */
public class Filter_greater_than_birthday implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    public Filter_greater_than_birthday() {
        Invoker.regist("filter_greater_than_birthday", this);
    }

    @Override
    public void execute(String S) {
    }

    @Override
    public String getInfo() {
        return "filter_greater_than_birthday: вывести все элемента значения birthday которых больше указанного.";
    }

}
