package common.commands;

import readers.*;
import common.*;
import enums.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

/**
 * Команда "Добавить-ка ещё! (но только если самый высокий)"
 */

public class Add_if_max implements Command {

    static boolean hasName = false;  // показывает, было ли добавлено имя элемента
    static boolean  hasCoordinates = false; // показывает, было ли добавлено поле coordinates
    static boolean  hasHairColor = false; //показывает, было ли добавлено поле HairColor
    static boolean hasNationality = false; // показывает, было ли добавлено поле Nationality
    static boolean hasLocation = false; // показывает, было ли добавлено поле Location
    static boolean hasBirthday = false; // показывает, было ли добавлено поле Birthday
    static boolean hasHeight = false; // показывает, было ли добавлено поле Height

    static String name = null;
    static String coordinateX = null;
    static String coordinateY = null;
    static String LocationX = null;
    static String LocationY = null;
    static String LocationZ = null;
    static String LocationName = null;
    static String nationality = null;
    static String hairColor = null;
    static String birthday = null;
    static String height = null;

    public Add_if_max() {
        Invoker.regist("add_if_max", this);
    }

    private static final long serialVersionUID = 6529685098267757690L;

    @Override
    public void execute(String s) {
    }

    @Override
    public String getInfo() {
        return "add_if_max {element} : добавить новый элемент в коллекцию";
    }

    /**
     * Метод для создания строки
     *
     * @return строка
     */
    public static String makeString() {

        while (!hasName) addName();
        while (!hasCoordinates) addCoordinates();
        while (!hasHeight) addHeight();
        while (!hasBirthday) addBirthday();
        while (!hasLocation) addLocation();
        while (!hasHairColor) addHairColor();
        while (!hasNationality) addNationality();
        String s = name + " " + coordinateX + " " + coordinateY + " " + LocationX + " " + LocationY + " " + LocationZ + " " +
                LocationName + " " + height + " " + birthday + " " + hairColor + " " + nationality;
        hasName = false;
        hasCoordinates = false;
        hasBirthday = false;
        hasLocation = false;
        hasHeight = false;
        hasHairColor = false;
        hasNationality = false;
        Add_if_max.name = null;
        Add_if_max.coordinateX = null;
        Add_if_max.coordinateY = null;
        Add_if_max.LocationX = null;
        Add_if_max.LocationY = null;
        Add_if_max.LocationZ = null;
        Add_if_max.LocationName = null;
        Add_if_max.nationality = null;
        Add_if_max.hairColor = null;
        Add_if_max.birthday = null;
        Add_if_max.height = null;

        return s;
    }

    protected static void addName() {
        try {
            System.out.print("\n" + "Как вы хотите, чтобы его звали?  ");
            String name = utility.ClientMain.reader.readLine() ;
            if (name.equals("") | name == null) {
                System.out.println("Пустая строка ни к чему не приведёт. Пока ты смотришь в пустую строку, пустая строка смотрит в тебя...");
                return;
            }
            if (name.trim().split(" ").length !=1 ) {
                System.out.println("Имя должно состоять из одного слова.");
                return;
            }
            Add_if_max.name = name.trim();
            hasName = true;
        } catch (IOException e) {
            System.out.println("Ошибка ввода.");
        } catch (Exception e ) {
            System.out.println("Ошибка ввода. Попробуйте ещё разок.");
            return;
        }
    }
    protected static void addBirthday() {
        try {
            System.out.print("\n" + "Введите день рождения в формате yyyy-mm-ddThh:mm:ss ");
            String s = utility.ClientMain.reader.readLine() ;
            if (name.equals("") | name == null) {
                System.out.println("Пустая строка ни к чему не приведёт. Пока ты смотришь в пустую строку, пустая строка смотрит в тебя...");
                return;
            }
            LocalDateTime localDateTime;
            try {
                localDateTime = LocalDateTime.parse(s);
            } catch (DateTimeParseException e){
                System.out.println("Неверный формат, попробуйте еще раз");
                return;
            }
            Add_if_max.birthday = localDateTime.toString();
            hasBirthday = true;
        } catch (IOException e) {
            System.out.println("Ошибка ввода.");
        } catch (Exception e ) {
            System.out.println("Ошибка ввода. Попробуйте ещё разок.");
            return;
        }
    }

    protected static void addCoordinates() {
        try {
            System.out.print("\n" + "Координаты, пожалуйста." + "\n" + "double X = ");
            String s = utility.ClientMain.reader.readLine() ;
            if (s.equals("") | s == null) {
                System.out.println("Введена пустая строка. Не надо так.");
                return;
            }
            Double coordinateX;
            try {
                coordinateX = Checker.doubleChecker(s);
            } catch (NullPointerException e) {
                System.out.println("Неправильный тип. Coordinate X должно быть типа double." + "\n Попробуем ещё разок!");
                return;
            }
            if ((double) coordinateX <= -836) {
                System.out.println("Coordinate x должно быть больше -836");
                return;
            }

            System.out.print("double Y = ");
            Double coordinateY;
            try {
                s = utility.ClientMain.reader.readLine();
                if (s.equals("") | s == null) {
                    System.out.println("Введена пустая строка. Не надо так.");
                    return;
                }
                coordinateY = Checker.doubleChecker(s);
            } catch (NullPointerException e) {
                System.out.println("Неправильный тип. Coordinate Y должно быть типа double" + "\n Попробуем ещё разок!");
                return;
            }
            if ((double) coordinateY >= 840) {
                System.out.println("Coordinate y должно быть меньше 840");
                return;
            }
            Add_if_max.coordinateX = coordinateX.toString();
            Add_if_max.coordinateY = coordinateY.toString();
            hasCoordinates = true;
        }
        catch (IOException e ) {
            System.out.println("Ошибка ввода.");
        } catch (Exception e ) {
            System.out.println("Ошибка ввода. Попробуйте ещё разок.");
            return;
        }
    }

    protected static void addHeight() {
        try {
            System.out.print("\n" + "Давай посмотрим, что у нас там с ростом. (double)  ");
            String s = utility.ClientMain.reader.readLine();
            if (s.equals("") | s == null) {
                System.out.println("Теперь height = null");
                hasHeight = true;
                return;
            }
            Double height;
            try {
                height = Checker.doubleChecker(s);
            } catch (NullPointerException e) {
                System.out.println("Неправильный тип. height должно быть типа double." + "\n Попробуем ещё разок!");
                return;
            }
            if (!(height > 1)) {
                System.out.println("Значение Height должно быть больше 1");
                return;
            }
            Add_if_max.height = height.toString();
            hasHeight = true;
        } catch (IOException e ) {
            System.out.println("Ошибка ввода.");
        } catch (Exception e ) {
            System.out.println("Ошибка ввода. Попробуйте ещё разок.");
            return;
        }
    }

    protected static void addHairColor() {
        try {
            System.out.print("\n" + "Введите один из типов волос: зеленый, желтый, красный, коричневый  ");
            String s = utility.ClientMain.reader.readLine() ;
            if (s.equals("") | s == null) {
                System.out.println("Пустая строка ни к чему не приведёт. Пока ты смотришь в пустую строку, пустая строка смотрит в тебя...");
                return;
            }
            if (Color.getValue(s) == null) {
                System.out.println("Такого типа волос нет");
                return;
            }
            Add_if_max.hairColor = Color.getValue(s).str;
            hasHairColor = true;
        } catch (IOException e) {
            System.out.println("Ошибка ввода.");
        } catch (Exception e ) {
            System.out.println("Ошибка ввода. Попробуйте ещё разок.");
            return;
        }
    }

    protected static void addNationality() {
        try {
            System.out.print("\n" + "Введите одну из национальностей: Китай, Тайланд, Франция, Корея  ");
            String s = utility.ClientMain.reader.readLine() ;
            if (s.equals("") | s == null) {
                System.out.println("Пустая строка ни к чему не приведёт. Пока ты смотришь в пустую строку, пустая строка смотрит в тебя...");
                return;
            }
            if (Country.getValue(s) == null) {
                System.out.println("Такой национальности нет  ");
                return;
            }
            Add_if_max.nationality = Country.getValue(s).str;
            hasNationality = true;
        } catch (IOException e) {
            System.out.println("Ошибка ввода.");
        } catch (Exception e ) {
            System.out.println("Ошибка ввода. Попробуйте ещё разок.");
            return;
        }
    }

    protected static void addLocation() {
        try {
            System.out.print("\n" + "Координаты ллокации " + "\n" + "float x = ");

            String s = utility.ClientMain.reader.readLine();
            if (s.equals("") | s == null) {
                System.out.println("Location = null.");
                hasLocation = true;
                return;
            }
            Float locationX;
            try {
                locationX = Checker.floatChecker(s);
            } catch (NullPointerException e) {
                System.out.println("Неправильный тип. location (X) должно быть типа float." + "\n Попробуем ещё разок!");
                return;
            }

            System.out.print("float y = ");
            Float locationY;
            s = utility.ClientMain.reader.readLine();
            if (s.equals("") | s == null) {
                System.out.println("Location = null.");
                hasLocation = true;
                return;
            }
            try {
                locationY = Checker.floatChecker(s);
            } catch (NullPointerException e) {
                System.out.println("Неправильный тип. location (Y) должно быть типа float." + "\n Попробуем ещё разок!");
                return;
            }

            System.out.print("int z = ");
            Integer locationZ;
            s = utility.ClientMain.reader.readLine();
            if (s.equals("") | s == null) {
                System.out.println("Location = null.");
                hasLocation = true;
                return;
            }
            try {
                locationZ = Checker.intChecker(s);
            } catch (NullPointerException e) {
                System.out.println("Неправильный тип. location (Z) должно быть типа int." + "\n Попробуем ещё разок!");
                return;
            }

            System.out.print("Имя локации:  ");
            String locationName = utility.ClientMain.reader.readLine();
            if (locationName.trim().equals("") | locationName == null) {
                System.out.println("LocationFrom = null.");
                hasLocation = true;
                return;
            }
            if (locationName.trim().split(" ").length !=1 ) {
                System.out.println("Имя должно состоять из одного слова.");
                return;
            }
            Add_if_max.LocationX = locationX.toString();
            Add_if_max.LocationY = locationY.toString();
            Add_if_max.LocationZ = locationZ.toString();
            Add_if_max.LocationName = locationName.trim();
            hasLocation = true;
        }
        catch (IOException e ) {
            System.out.println("Ошибка ввода.");
        } catch (Exception e ) {
            System.out.println("Ошибка ввода. Попробуйте ещё разок.");
            return;
        }
    }

    public static String makeString(String[] s){
        while (!hasName) addName(s[0]);
        System.out.println("name = " + name);
        while (!hasCoordinates) addCoordinates(s[1], s[2]);
        System.out.println("coordinate X = " + coordinateX + "\ncoordinate Y = " + coordinateY);
        while (!hasLocation) addLocation(s[3], s[4], s[5], s[6]);
        System.out.println("LocationX = " + LocationX + "\nLocationY = " + LocationY +  "\nLocationZ = " + LocationZ +"\nLocationName = " + LocationName);
        while (!hasHeight) addHeight(s[7]);
        System.out.println("height = " + height);
        while (!hasBirthday) addBirthday(s[8]);
        System.out.println("birthday = " + birthday);
        while (!hasHairColor) addHairColor(s[9]);
        System.out.println("hairColor = " + hairColor);
        while (!hasNationality) addNationality(s[10]);
        System.out.println("nationality = " + nationality);

        String s1 = name + " " + coordinateX + " " + coordinateY + " " + LocationX + " " + LocationY + " " + LocationZ + " " +
                LocationName + " " + height + " " + birthday + " " + hairColor + " " + nationality;
        hasName = false;
        hasCoordinates = false;
        hasBirthday = false;
        hasLocation = false;
        hasHeight = false;
        hasHairColor = false;
        hasNationality = false;
        Add_if_max.name = null;
        Add_if_max.coordinateX = null;
        Add_if_max.coordinateY = null;
        Add_if_max.LocationX = null;
        Add_if_max.LocationY = null;
        Add_if_max.LocationZ = null;
        Add_if_max.LocationName = null;
        Add_if_max.nationality = null;
        Add_if_max.hairColor = null;
        Add_if_max.birthday = null;
        Add_if_max.height = null;

        return s1;
    }

    protected static void addName(String s) {
        try {
            String name = s;
            if (name.trim().equals("") | name == null) {
                return;
            }
            if (name.trim().split(" ").length !=1 ) {
                System.out.println("Имя должно состоять из одного слова.");
                return;
            }
            Add_if_max.name = name.trim();
            hasName = true;
        } catch (Exception e ) {
            return;
        }
    }

    protected static void addCoordinates(String s0, String s1) {
        try {
            Double coordinateX;
            try {
                coordinateX = Checker.doubleChecker(s0);
            } catch (NullPointerException e) {
                return;
            }
            if ((double) coordinateX <= -836) {
                return;
            }
            Double coordinateY;
            try {
                coordinateY = Checker.doubleChecker(s1);
            } catch (NullPointerException e) {
                return;
            }
            if ((double) coordinateY >= 840) {
                return;
            }
            Add_if_max.coordinateX = coordinateX.toString();
            Add_if_max.coordinateY = coordinateY.toString();
            hasCoordinates = true;
        } catch (Exception e) {
            return;
        }
    }

    protected static void addLocation(String s0, String s1, String s2, String s3) {
        try {
            if (s0.trim().equals("")) {
                return;
            }
            Float locationX;
            try {
                locationX = Checker.floatChecker(s0);
            } catch (NullPointerException e) {
                return;
            }

            Float locationY;
            if (s1.trim().equals("")) {
                return;
            }
            try {
                locationY = Checker.floatChecker(s1);
            } catch (NullPointerException e) {
                return;
            }

            Integer locationZ;
            if (s2.trim().equals("")) {
                return;
            }
            try {
                locationZ = Checker.intChecker(s2);
            } catch (NullPointerException e) {
                return;
            }

            if (s3.trim().equals("")) {
                return;
            }
            if (s3.trim().split(" ").length !=1 ) {
                System.out.println("Имя должно состоять из одного слова.");
                return;
            }
            Add_if_max.LocationX = locationX.toString();
            Add_if_max.LocationY = locationY.toString();
            Add_if_max.LocationZ = locationZ.toString();
            Add_if_max.LocationName = s3.trim();
            hasLocation = true;

        } catch (Exception e) {
            return;
        }
    }

    protected static void addHeight(String s) {
        try {
            if (s.trim().equals("") | s.toLowerCase().trim().equals("null")) {
                hasHeight = true;
                return;
            }
            Double height;
            try {
                height = Checker.doubleChecker(s);
            } catch (NullPointerException e) {
                return;
            }
            if (!(height > 1)) {
                return;
            }
            Add_if_max.height = height.toString();
            hasHeight = true;
        } catch (Exception e) {
            return;
        }
    }

    protected static void addBirthday(String s) {
        try {
            String birthday = s;
            if (birthday.trim().equals("") | birthday == null) {
                return;
            }
            LocalDateTime localDateTime;
            try {
                localDateTime = LocalDateTime.parse(birthday);
            } catch (DateTimeParseException e){
                System.out.println("Неверный формат, попробуйте еще раз");
                return;
            }
            Add_if_max.birthday = localDateTime.toString();
            hasBirthday = true;
        } catch (Exception e ) {
            return;
        }
    }

    protected static void addHairColor(String s) {
        try {
            String hairColor = s;
            if (hairColor.trim().equals("") | hairColor == null) {
                return;
            }
            if (Color.getValue(hairColor) == null) {
                System.out.println("Такого типа волос нет");
                return;
            }
            Add_if_max.hairColor = hairColor.trim();
            hasHairColor = true;
        } catch (Exception e ) {
            return;
        }
    }

    protected static void addNationality(String s) {
        try {
            String nationality = s;
            if (nationality.trim().equals("") | nationality == null) {
                return;
            }
            if (Country.getValue(nationality) == null) {
                System.out.println("Такой национальности нет ");
                return;
            }
            Add_if_max.nationality = nationality.trim();
            hasNationality = true;
        } catch (Exception e ) {
            return;
        }
    }

}
