package com.example.car.controller;


import com.example.car.dtos.CarDto;
import com.example.car.entity.Car;
import com.example.car.entity.Vehicle;
import com.example.car.mapper.CarMapper;
import com.example.car.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("cars")
@Slf4j
public class CarController

{
    // Logger log = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarService carService;

    @GetMapping

    public ResponseEntity<?> listarCoches()
    {
        log.info("---you have accesed correctly to the application----");
        ArrayList<Vehicle> vehicleList = carService.listarCoches();
        String logMsg = vehicleList.isEmpty()
                        ? "No Cars found"

                        : String.format("Found %s cars", vehicleList.size());
        log.info("listing vehicles...");
        //  vehicleList.stream().map(car -> car.toString()).forEach(car -> log.info(car));
        log.info(logMsg);
        return ResponseEntity.status(HttpStatus.OK).body(vehicleList);
    }

    @PostMapping(value = "")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> AñadirCoche(@RequestBody CarDto carDto)
    {
        Car car = CarMapper.convertToEntity(carDto);
        //  log.info("Successfully created");
        try
        {
            Optional<Car> car1 = Optional.of(car);
            if (car1.isPresent())
            {
                log.info("Successfully added");
                return ResponseEntity.ok().build();
            } else
            {
                log.info("not found");
                return ResponseEntity.notFound().build();
            }
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
 /*
      @PostMapping(value = "")
    @ResponseStatus(code = HttpStatus.CREATED)




   public Car AñadirCoche(@RequestBody Car c)
    {
        log.info("Successfully created");
        return carService.guardarCoche(c);
    }
*/
        @PutMapping(value = "/{id}")
       // @ResponseStatus(code = HttpStatus.OK)
        public ResponseEntity<?> update (@PathVariable Integer id, @RequestBody CarDto carDto)
        {
            Car car = CarMapper.convertToEntity(carDto);
            try
            {
                CarDto carDto1 = CarMapper.convertToDto(carService.actualizarCoche(id, car));
                Optional<CarDto> carDto2 = Optional.of(carDto1);
                if (carDto2.isPresent())
                {  log.info(String.format("Find Car by id '%d'",(id)));
                    return ResponseEntity.ok().body(carDto2.get());

                } else
                {  log.info(String.format("Car with id '%d' not found",(id)));
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
                }
            } catch (NumberFormatException e){
                return ResponseEntity.notFound().build();
              } catch (Exception e){
    return ResponseEntity.badRequest().build();
}

            }

        @DeleteMapping(value = "/{id}")
       // @ResponseStatus(code = HttpStatus.NO_CONTENT)
        public ResponseEntity<?> eliminarCoche (@PathVariable Integer id)
        {try
        {
            carService.eliminarCoche(id);
            log.info("Successfully deleted car with id '%d'", (id));
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
        }

        @GetMapping("/marca")
        @ResponseStatus(code = HttpStatus.OK)
        public void listarCochesPorMarca ()
        {
            log.info("listing vehicles by marca...");
            carService.listVehicleByBrand();
        }

        @GetMapping("/modelo")

        public ResponseEntity<?> listarCochesPorModelo ()
        {
            log.info("listing vehicles by model...");
            carService.listVehicleByModel();
            return ResponseEntity.status(HttpStatus.OK).build();
        }

/*
    @GetMapping("/greeting/{id}")

    public ResponseEntity<?> getGreeting(@PathVariable Integer id)
    {
        GreetingRequest greetingRequest=new GreetingRequest();
      greetingRequest.setGreeting("hellod");
      greetingRequest.setPersonName("jorge");
     // Pet pet=new Pet();
        return ResponseEntity.status(HttpStatus.OK).build();

    }
*/
        @GetMapping("/{id}")

        public ResponseEntity<?>  buscarPorId (@PathVariable Integer id)
        {
    try
    {
        CarDto carDto = CarMapper.convertToDto(carService.EncontrarCochePorID(id));
        Optional<CarDto> car1 = Optional.of(carDto);
        if (car1.isPresent())
        {   log.info(String.format("Find Car by id '%d'",(id)));
            return ResponseEntity.ok(car1.get());
        } else
        {    log.info(String.format("Car with id '%d' not found",(id)));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
        }
    }catch(Exception e)
    {
        return ResponseEntity.notFound().build();
    }

            //GreetingRequest greetingRequest = new GreetingRequest();
           // greetingRequest.setGreeting("hellod");
           // greetingRequest.setPersonName("jorge");

        }
    }
