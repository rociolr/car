package com.example.car.service;



import com.example.car.entity.Car;
import com.example.car.entity.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface CarService
{       public Integer siguienteIdVehiculo();
    public Collection<Vehicle> obtenerCoches();
    public ArrayList<Vehicle> listarCoches();
    public Car guardarCoche(Car c);
    public Car EncontrarCochePorID(Integer id);
    public void  eliminarCoche(Integer id);

     public Car actualizarCoche(Integer id, Car car);

    public void listVehicleByBrand();
    public void listVehicleByModel();
    public void PostConstruct();
}
