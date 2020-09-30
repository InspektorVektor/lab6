package App;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Поле класса Person
 */
@XmlRootElement
public class Coordinates implements Serializable {
    public Coordinates(){};

    /**
     * Конструктор
     * @param x координата X
     * @param y координата Y
     */

    public Coordinates(Double x, double y) {
        this.x = x;
        this.y = y;
    }

    private Double x; //Значение поля должно быть больше -836
    private double y; //Максимальное значение поля: 840, Поле не может быть null


    public Double getX() {
        return x;
    }
    @XmlElement
    public void setX(Double x) {
        this.x = x;
    }


    public double getY() {
        return y;
    }
    @XmlElement
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates(" +
                "x = " + x
                +  ", y = " + y
                + ')';
    }
}
