package pl.blackfernsoft.wsis.orm.hibernatejpa.entity;

import pl.blackfernsoft.wsis.orm.hibernatejpa.enums.CarType;
import pl.blackfernsoft.wsis.orm.hibernatejpa.enums.Color;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CAR")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CAR_ID")
    private Long id;

    @Column(name = "NAME",
            nullable = false,
            insertable = true,
            updatable = true)
    private String name;

    private Integer numberOfSeats;

    @Enumerated(EnumType.STRING)
    private Color color;

    @Enumerated(EnumType.ORDINAL)
    private CarType carType;

    @ElementCollection
    @CollectionTable(name = "RENTAL_ADDRESS", joinColumns = @JoinColumn(name = "CAR_ID"))
    private List<Address> rentalAddress = new ArrayList<Address>();

    @ElementCollection
    @CollectionTable(name = "RENTAL_DATES", joinColumns = @JoinColumn(name = "CAR_ID"))
    @Column(name = "RENTAL_DATES")
    private Collection<Date> rentalDates = new ArrayList<Date>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public List<Address> getRentalAddress() {
        return rentalAddress;
    }

    public void setRentalAddress(List<Address> rentalAddress) {
        this.rentalAddress = rentalAddress;
    }

    public Collection<Date> getRentalDates() {
        return rentalDates;
    }

    public void setRentalDates(Collection<Date> rentalDates) {
        this.rentalDates = rentalDates;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", color=" + color +
                ", carType=" + carType +
                ", rentalAddress=" + rentalAddress +
                ", rentalDates=" + rentalDates +
                '}';
    }
}
