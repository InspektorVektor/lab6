package common.commands;

import readers.*;
import common.*;
import enums.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

/**
 * Команда "Добавить-ка ещё!"
 */

public class Add implements Command {
    static int i = 0;

    static boolean hasName = false;  // показывает, было ли добавлено имя элемента
    static boolean  hasCoordinates = false; // показывает, было ли добавлено поле coordinates
    static boolean  hasHairColor = false; //показывает, было ли добавлено поле HeirColor
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

    public Add() {
        Invoker.regist("add", this);
    }

    private static final long serialVersionUID = 6529685098267757690L;

    @Override
    public void execute(String s) {
    }

    @Override
    public String getInfo() {
        return "add {element} : добавить новый элемент в коллекцию";
    }

    /**
     * Метод для создания строки
     *
     * @return строка
     */
    public static String makeString() {

        while (!hasName) addName();
        while (!hasCoordinates) addCoordinates();
        while (!hasLocation) addLocation();
        while (!hasHeight) addHeight();
        while (!hasBirthday) addBirthday();
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
        Add.name = null;
        Add.coordinateX = null;
        Add.coordinateY = null;
        Add.LocationX = null;
        Add.LocationY = null;
        Add.LocationZ = null;
        Add.LocationName = null;
        Add.nationality = null;
        Add.hairColor = null;
        Add.birthday = null;
        Add.height = null;

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
            Add.name = name.trim();
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
            System.out.print("\n" + "Введите день рождения в формате yyyy-mm-ddThh:mm:ss  ");
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
            Add.birthday = localDateTime.toString();
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
            Add.coordinateX = coordinateX.toString();
            Add.coordinateY = coordinateY.toString();
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
                System.out.println("Теперь рост = null");
                hasHeight = true;
                return;
            }
            Double height;
            try {
                height = Checker.doubleChecker(s);
            } catch (NullPointerException e) {
                System.out.println("Неправильный тип. рост должно быть типа double." + "\n Попробуем ещё разок!");
                return;
            }
            if (!(height > 1)) {
                System.out.println("Значение роста должно быть больше 1");
                return;
            }
            Add.height = height.toString();
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
            Add.hairColor = Color.getValue(s).str;
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
            Add.nationality = Country.getValue(s).str;
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
            System.out.print("\n" + "Координаты местности" + "\n" + "float x = ");

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
            Add.LocationX = locationX.toString();
            Add.LocationY = locationY.toString();
            Add.LocationZ = locationZ.toString();
            Add.LocationName = locationName.trim();
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
        if (!addName(s[0])) return "mistake";
        System.out.println("name = " + name);
        if (!addCoordinates(s[1], s[2])) return "mistake";
        System.out.println("coordinate X = " + coordinateX + "\ncoordinate Y = " + coordinateY);
        if (!addLocation(s[3], s[4], s[5], s[6])) return "mistake";
        System.out.println("LocationX = " + LocationX + "\nLocationY = " + LocationY +  "\nLocationZ = " + LocationZ +"\nLocationName = " + LocationName);
        if (!addHeight(s[7])) return "mistake";
        System.out.println("height = " + height);
        if(!addBirthday(s[8])) return "mistake";
        System.out.println("birthday = " + birthday);
        if(!addHairColor(s[9])) return "mistake";
        System.out.println("hairColor = " + hairColor);
        if(!addNationality(s[10])) return "mistake";
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
        Add.name = null;
        Add.coordinateX = null;
        Add.coordinateY = null;
        Add.LocationX = null;
        Add.LocationY = null;
        Add.LocationZ = null;
        Add.LocationName = null;
        Add.nationality = null;
        Add.hairColor = null;
        Add.birthday = null;
        Add.height = null;

        return s1;
    }

    protected static boolean addName(String s) {
        try {
            String name = s;
            if (name.trim().equals("") | name == null) {
                return false;
            }
            if (name.trim().split(" ").length !=1 ) {
                System.out.println("Имя должно состоять из одного слова.");
                return false;
            }
            Add.name = name.trim();
            hasName = true;
        } catch (Exception e ) {
            return false;
        }
        return true;
    }

    protected static boolean addCoordinates(String s0, String s1) {
        try {
            Double coordinateX;
            try {
                coordinateX = Checker.doubleChecker(s0);
            } catch (NullPointerException e) {
                return false;
            }
            if ((double) coordinateX <= -836) {
                return false;
            }
            Double coordinateY;
            try {
                coordinateY = Checker.doubleChecker(s1);
            } catch (NullPointerException e) {
                return false;
            }
            if ((double) coordinateY >= 840) {
                return false;
            }
            Add.coordinateX = coordinateX.toString();
            Add.coordinateY = coordinateY.toString();
            hasCoordinates = true;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    protected static boolean addLocation(String s0, String s1, String s2, String s3) {
        try {
            if (s0.toLowerCase().trim().equals("null") | s0.toLowerCase().trim().equals("")) {
                hasLocation = true;
                return false;
            }
            Float locationX;
            try {
                locationX = Checker.floatChecker(s0);
            } catch (NullPointerException e) {
                return false;
            }

            Float locationY;
            if (s1.toLowerCase().trim().equals("null") | s1.toLowerCase().trim().equals("")) {
                hasLocation = true;
                return false;
            }
            try {
                locationY = Checker.floatChecker(s1);
            } catch (NullPointerException e) {
                return false;
            }

            Integer locationZ;
            if (s2.toLowerCase().trim().equals("null") | s2.toLowerCase().trim().equals("")) {
                hasLocation = true;
                return false;
            }
            try {
                locationZ = Checker.intChecker(s2);
            } catch (NullPointerException e) {
                return false;
            }

            if (s3.trim().equals("")) {
                hasLocation = true;
                return false;
            }
            if (s3.trim().split(" ").length !=1 ) {
                System.out.println("Имя должно состоять из одного слова.");
                return false;
            }
            Add.LocationX = locationX.toString();
            Add.LocationY = locationY.toString();
            Add.LocationZ = locationZ.toString();
            Add.LocationName = s3.trim();
            hasLocation = true;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    protected static boolean addHeight(String s) {
        try {
            if (s.trim().equals("") | s.toLowerCase().trim().equals("null")) {
                hasHeight = true;
                return false;
            }
            Double height;
            try {
                height = Checker.doubleChecker(s);
            } catch (NullPointerException e) {
                return false;
            }
            if (!(height > 1)) {
                return false;
            }
            Add.height = height.toString();
            hasHeight = true;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    protected static boolean addBirthday(String s) {
        try {
            String birthday = s;
            if (birthday.trim().equals("") | birthday == null) {
                return false;
            }
            LocalDateTime localDateTime;
            try {
                localDateTime = LocalDateTime.parse(birthday);
            } catch (DateTimeParseException e){
                System.out.println("Неверный формат, попробуйте еще раз");
                return false;
            }
            Add.birthday = localDateTime.toString();
            hasBirthday = true;
        } catch (Exception e ) {
            return false;
        }
        return true;
    }

    protected static boolean addHairColor(String s) {
        try {
            String hairColor = s;
            if (hairColor.trim().equals("") | hairColor == null) {
                return false;
            }
            if (Color.getValue(hairColor) == null) {
                System.out.println("Такого типа волос нет");
                return false;
            }
            Add.hairColor = hairColor.trim();
            hasHairColor = true;
        } catch (Exception e ) {
            return false;
        }
        return true;
    }

    protected static boolean addNationality(String s) {
        try {
            String nationality = s;
            if (nationality.trim().equals("") | nationality == null) {
                return false;
            }
            if (Country.getValue(nationality) == null) {
                System.out.println("Такой национальности нет");
                return false;
            }
            Add.nationality = nationality.trim();
            hasNationality = true;
        } catch (Exception e ) {
            return false;
        }
        return true;
    }

}
