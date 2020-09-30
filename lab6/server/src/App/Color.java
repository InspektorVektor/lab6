package App;


import javax.xml.bind.annotation.XmlEnum;
import java.io.Serializable;

/**
 * Список Цветов
 */
@XmlEnum
public enum Color implements Serializable {
    GREEN("зеленый"),
    RED("красный"),
    YELLOW("желтый"),
    BROWN("коричневый");

    private String str;

    Color(String str) {
        this.str = str;
    }

    public static Color getValue(String value) {
        for (Color color : Color.values()) {
            if (color.str.equals(value)) return color;
        }
        return null;
    }

}

