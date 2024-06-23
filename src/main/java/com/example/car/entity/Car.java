package com.example.car.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "car")
public class Car extends Vehicle
{
    private Integer numberOfDoor;
    private Boolean isConvertible;
    private  Integer Milleage;
    private Double price;
    private String description;
    private String color;
    private String fuelType;



    public Car()
    {
    }

    public Car(Integer id,String brand, String model, Integer year, Integer numberOfDoor, Boolean isConvertible, Double price, String description, String color, String fuelType)
    {
        super(id,brand, model, year);
        this.numberOfDoor = numberOfDoor;
        this.isConvertible = isConvertible;
        this.price=price;
        this.description=description;
        this.color=color;
        this.fuelType=fuelType;
    }

    @Override
    public String toString()
    {
        return "Car{" + super.toString() +
                "numberOfDoor=" + numberOfDoor +
                ", isConvertible=" + isConvertible +
                ", Milleage=" + Milleage +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", fuelType='" + fuelType + '\'' +
                "} " ;
    }
}
