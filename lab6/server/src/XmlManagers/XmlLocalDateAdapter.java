package XmlManagers;

import java.time.LocalDateTime;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Класс для адаптации даты к xml
 */

public class XmlLocalDateAdapter extends XmlAdapter<String, LocalDateTime> {

    public LocalDateTime unmarshal(String v) throws Exception {
        return LocalDateTime.parse(v);
    }

    public String marshal(LocalDateTime v) throws Exception {
        return v.toString();
    }
}
