package App;
import javax.xml.bind.annotation.XmlEnum;
import java.io.Serializable;

/**
 * Список национальностей
 */
@XmlEnum
public enum Country implements Serializable {
    FRANCE("Франция"),
    SPAIN("Испания"),
    CHINA("Китай"),
    THAILAND("Таиланд"),
    SOUTH_KOREA("Корея");

    public String str;

    Country(String str) {
        this.str = str;
    }

    public static Country getValue(String value) {
        for (Country country : Country.values()) {
            if (country.str.equals(value)) return country;
        }
        return null;
    }

}
