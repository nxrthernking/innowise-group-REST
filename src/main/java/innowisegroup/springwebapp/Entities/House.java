package innowisegroup.springwebapp.Entities;


import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class House extends RealEstate {

    private String houseType;
    private double landArea;

    public House() {
    }

    public House(String city, String street, String houseNumber, double totalArea, BigDecimal price,
                 String houseType, double landArea,boolean isDeleted) {
        super(city, street, houseNumber, totalArea, price, isDeleted);
        this.houseType = houseType;
        this.landArea = landArea;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public double getLandArea() {
        return landArea;
    }

    public void setLandArea(double landArea) {
        this.landArea = landArea;
    }

    @Override
    public String toString() {
        return "House{" +
                super.toString() +
                "houseType='" + houseType + '\'' +
                ", landArea=" + landArea +
                '}';
    }
}
