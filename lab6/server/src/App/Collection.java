package App;

import Generators.DateGenerator;
import Generators.IDGenerator;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

/**
 * Класс-коллекция
 */
public class Collection implements Serializable {

    @XmlElement
    public static HashSet<Person> people;

    @XmlTransient
    private final LocalDate initializationDate;
    @XmlTransient
    private String path;


    /**
     * Конструктор коллекии
     */
    public Collection(){
        this.people = new HashSet<>();
        this.initializationDate = DateGenerator.generateCurrentDate();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    @XmlTransient
    /**
     * Метод для получения даты
     * @return initializationDate
     */
    public LocalDate getInitializationDate() {
        return initializationDate;
    }


    /**
     * Метод поиска элемента по id
     * @param id id
     * @return элемент коллекции
     */
    public Person searchById(int id) {
        for (Person r : people) {
            if (r.getId().equals(id))
                return r;
        }
        return null;
    }

    /**
     * Метод для создания уникального id
     * @return уникальный id
     */
    public int generateUniqueID() {
        int id;
        do {
            id = IDGenerator.generateNewID();
        } while (this.searchById(id) != null);
        return id;
    }

}
