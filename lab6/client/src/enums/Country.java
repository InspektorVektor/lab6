package enums;
import javax.xml.bind.annotation.XmlEnum;
/**
 * Список национальностей
 */
@XmlEnum
public enum Country {
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
