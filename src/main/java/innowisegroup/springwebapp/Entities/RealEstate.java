package innowisegroup.springwebapp.Entities;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "real_estate")
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "className")
public abstract class RealEstate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String street;
    private String houseNumber;
    private double totalArea;
    private BigDecimal price;
    private boolean isDeleted;

    public RealEstate() {
    }

    public RealEstate(String city, String street, String houseNumber, double totalArea, BigDecimal price, boolean isDeleted) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.totalArea = totalArea;
        this.price = price;
        this.isDeleted = isDeleted;
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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
    @Override
    public String toString() {
        return
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", totalArea=" + totalArea +
                ", price=" + price ;

    }


}
