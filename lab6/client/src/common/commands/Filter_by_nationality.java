package common.commands;

import common.*;

/**
 * Команда "Вывести вле элементы определённой национальности"
 */
public class Filter_by_nationality implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    public Filter_by_nationality() {
        Invoker.regist("filter_by_nationality", this);
    }


    @Override
    public void execute(String S) {
    }

    @Override
    public String getInfo() {
        return "filter_by_nationality: вывести все элементы определённой национальности.";
    }

}
