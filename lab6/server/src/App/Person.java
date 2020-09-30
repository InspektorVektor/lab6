package App;


import XmlManagers.XmlLocalDateAdapter;
import XmlManagers.XmlZonedDateAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
/**
 * Класс, хранимый в Collection
 */
@XmlRootElement
public class Person implements Comparable<Person>, Serializable {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Double height; //Поле может быть null, Значение поля должно быть больше 0
    private LocalDateTime birthday; //Поле может быть null
    private Color hairColor; //Поле не может быть null
    private Country nationality; //Поле может быть null
    private Location location; //Поле не может быть null

    public Person(){};


    public Integer getId() {
        return id;
    }
    @XmlElement
    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }


    public Coordinates getCoordinates() {
        return coordinates;
    }
    @XmlElement
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @XmlJavaTypeAdapter(value = XmlZonedDateAdapter.class)

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }
    @XmlElement
    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }


    public Double getHeight() {
        return height;
    }
    @XmlElement
    public void setHeight(Double height) {
        this.height = height;
    }

    @XmlJavaTypeAdapter(value = XmlLocalDateAdapter.class)

    public LocalDateTime getBirthday() {
        return birthday;
    }
    @XmlElement
    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }


    public Color getHairColor() {
        return hairColor;
    }
    @XmlElement
    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }


    public Country getNationality() {
        return nationality;
    }
    @XmlElement
    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }


    public Location getLocation() {
        return location;
    }
    @XmlElement
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", height=" + height +
                ", birthday=" + birthday +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality +
                ", location=" + location +
                '}';
    }

    @Override
    public int compareTo(Person r) {
    if (this.getHeight()==r.getHeight()){
        return  0;
        } else if (this.getHeight() > r.getHeight()){
        return 1;
        }else{
        return -1;
        }
    }
}
