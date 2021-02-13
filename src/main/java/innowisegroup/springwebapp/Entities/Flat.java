package innowisegroup.springwebapp.Entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "t_realty")
public class Flat extends RealEstate {

    private int numberOfRooms;
    private int floorNumber;

    public Flat() {
    }

    public Flat(String city, String street, String houseNumber,
                double totalArea, BigDecimal price, int numberOfRooms, int floorNumber) {
        super(city, street, houseNumber, totalArea, price);
        this.numberOfRooms = numberOfRooms;
        this.floorNumber = floorNumber;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}
