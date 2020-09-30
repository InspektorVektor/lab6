package common.commands;

import common.*;

/**
 * Команда "МАКСИМАЛЬНЫЙ"
 */
public class Max_by_height implements Command {
        private static final long serialVersionUID = 6529685098267757690L;

        public Max_by_height() {
                Invoker.regist("max_by_height", this);
        }

        /**
         * Метод для вывода элемента коллекции People с максимальным значением поля height
         */
        @Override
        public void execute(String s) {
        }

        @Override
        public String getInfo() {
                return "max_by_height: вывести любой объект из коллекции, значение поля height которого является максимальным";
        }

}

