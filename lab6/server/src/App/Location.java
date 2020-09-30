package App;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Поле класса Person
 */
@XmlRootElement
public class Location implements Serializable {
    private float x; //Поле не может быть null
    private Float y; //Поле не может быть null
    private Integer z; //Поле не может быть null
    private String name; //Поле не может быть null

    public Location(){};

    /**
     * Конструктор
     * @param x Координата x
     * @param y Координата y
     * @param name Имя
     */
    public Location(float x, Float y, Integer z,  String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }


    public Float getX() {
        return x;
    }
    @XmlElement
    public void setX(Float x) {
        this.x = x;
    }


    public float getY() {
        return y;
    }
    @XmlElement
    public void setY(float y) {
        this.y = y;
    }

    public Integer getZ() {
        return z;
    }
    @XmlElement
    public void setZ(Integer z) {
        this.z = z;
    }

    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Location(" +
                "x = " + x +
                ", y = " + y +
                ", z = " + z +
                ", name = " + name +
                ')';
    }

}
