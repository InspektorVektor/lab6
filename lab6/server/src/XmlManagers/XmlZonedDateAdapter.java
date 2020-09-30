package XmlManagers;

import java.time.ZonedDateTime;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Класс для адаптации даты к xml 
 */

public class XmlZonedDateAdapter extends XmlAdapter<String, ZonedDateTime> {

    public ZonedDateTime unmarshal(String v) throws Exception {
        return ZonedDateTime.parse(v);
    }

    public String marshal(ZonedDateTime v) throws Exception {
        return v.toString();
    }
}

