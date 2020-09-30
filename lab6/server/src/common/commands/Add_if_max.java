package common.commands;

import common.*;
import App.*;
import utility.ServerMain;
import utility.ServerSender;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * Команда "Добавить-ка ещё!" (но только если человек самый высокий)
 */
public class Add_if_max implements Command {
    static boolean hasName = false;  // показывает, было ли добавлено имя элемента
    static boolean  hasCoordinates = false; // показывает, было ли добавлено поле coordinates
    static boolean  hasHairColor = false; //показывает, было ли добавлено поле HairColor
    static boolean hasNationality = false; // показывает, было ли добавлено поле Nationality
    static boolean hasLocation = false; // показывает, было ли добавлено поле Location
    static boolean hasBirthday = false; // показывает, было ли добавлено поле Birthday
    static boolean hasHeight = false; // показывает, было ли добавлено поле Height

    private static final long serialVersionUID = 6529685098267757690L;

    /**
     * Метод для добавления новых элементов в коллекцию (но только если человек самый высокий)
     *
     * @param string строка с полями объекта people
     */
    @Override
    public void execute(String string) {


        String[] s = string.split(" ");

        double maxHeight = 0;
        for (Person r : ServerMain.c.people) {
            if (r.getHeight() > maxHeight) {
                maxHeight = r.getHeight();
            }
        }

        if (Double.parseDouble(s[7]) > maxHeight){
            Person person = new Person();
            person.setId(ServerMain.c.generateUniqueID());
            person.setCreationDate(ZonedDateTime.now());
            person.setName(s[0]);
            person.setCoordinates(new Coordinates(Double.parseDouble(s[1]), Double.parseDouble(s[2])));
            if (!s[3].equals("null"))
                person.setLocation(new Location(Float.parseFloat(s[3]), Float.parseFloat(s[4]), Integer.parseInt(s[5]), s[6]));
            if (!s[7].equals("null")) person.setHeight(Double.parseDouble(s[7]));
            person.setBirthday(LocalDateTime.parse(s[8]));
            person.setHairColor(Color.getValue(s[9]));
            person.setNationality(Country.getValue(s[10]));
            ServerMain.c.people.add(person);
            ServerSender.send("Объект был добавлен в коллекцию.", 0);
        }else{
            ServerSender.send("Объект не был добавлен в коллекцию.", 0);
        }
    }

    /**
     * Метод для создания строки
     *
     * @return строка
     */
    public static String makeString() {
        return null;
    }

    /**
     * Метод добавления имени в элемент
     */
    protected static void addName() {
    }

    /**
     * Метод добавления координат в элемент
     */
    protected static void addCoordinates() {
    }

    /**
     * Метод добавления поля Location в элемент
     */
    protected static void addLocation() {
    }


    /**
     * Метод добавления поля Birthday в элемент
     */
    protected static void addBirthday() {
    }

    /**
     * Метод добавления поля Height в элемент
     */
    protected static void addHeight() {
    }
    /**
     * Метод добавления поля HairColor в элемент
     */
    protected static void addHairColor() {
    }
    /**
     * Метод добавления поля Nationality в элемент
     */
    protected static void addNationality() {
    }


    @Override
    public String getInfo() {
        return "add_if_max {element} : добавить новый элемент в коллекцию (но только если самый высокий)";
    }
}