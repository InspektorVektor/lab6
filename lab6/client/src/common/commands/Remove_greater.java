package common.commands;

import common.*;

/**
 * Команда "УДОЛИ!"
 */
public class Remove_greater implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    public Remove_greater() {
        Invoker.regist("remove_greater", this);
    }

    /**
     * метод удаления из коллекции всех элементов, превышающих заданный рост
     */
    @Override
    public void execute(String s) {
    }

    @Override
    public String getInfo() {
        return "remove_greater : удалить из коллекции все элементы, превышающие заданный рост";
    }

}
