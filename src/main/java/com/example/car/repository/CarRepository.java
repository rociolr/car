package com.example.car.repository;

import com.example.car.entity.Car;
import com.example.car.entity.Vehicle;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface CarRepository
{
    public Integer siguienteIdVehiculo();
    public Collection<Vehicle> obtainCars();
    public ArrayList<Vehicle> listCars();
    public Car saveCar(Car c);
    public Car FindCarById(Integer Id);
    public void  deleteCar(Integer id);
    public Car updateCar(Integer id, Car car);
    public void listVehicleByBrand();
    public void listVehicleByModel();

}
