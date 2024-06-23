package com.example.car.dtos;


import lombok.Data;

@Data
public class CarDto extends VehicleDto
{
    private Integer numberOfDoor;
    private  Integer Milleage;
    private Double price;
    private String description;
    private String color;
    private String fuelType;



    public CarDto()
    {
    }

    public CarDto(Integer id,String brand, String model, Integer year, Integer numberOfDoor, Double price, String description, String color, String fuelType)
    {
        super(id,brand, model, year);
        this.numberOfDoor = numberOfDoor;
        this.price=price;
        this.description=description;
        this.color=color;
        this.fuelType=fuelType;
    }

    @Override
    public String toString()
    {
        return "CarDto{" + super.toString() +
                "numberOfDoor=" + numberOfDoor +
                ", Milleage=" + Milleage +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", fuelType='" + fuelType + '\'' +
                "} " ;
    }
}


