package innowisegroup.springwebapp.Entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "real_estate")
public abstract class RealEstate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String street;
    private String houseNumber;
    private double totalArea;
    private BigDecimal price;

    public RealEstate() {
    }

    public RealEstate(String city, String street, String houseNumber, double totalArea, BigDecimal price) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.totalArea = totalArea;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


}
