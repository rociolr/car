package com.example.car.entity;


import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public  class Vehicle

    {    @Id
    @GeneratedValue
        private Integer id;
        private String brand;
        private String model;
        private Integer year;


        public Integer getId ()
        {
            return id;
        }

        public void setId (Integer id)
        {
            this.id = id;
        }

        public String getBrand ()
        {
            return brand;
        }

        public void setBrand (String brand)
        {
            this.brand = brand;
        }

        public String getModel ()
        {
            return model;
        }

        public void setModel (String model)
        {
            this.model = model;
        }

        public Integer getYear ()
        {
            return year;
        }

        public void setYear (Integer year)
        {
            this.year = year;
        }

    public Vehicle()
        {
        }

    public Vehicle(Integer id, String brand, String model, Integer year)
        {
            this.id = id;
            this.brand = brand;
            this.model = model;
            this.year = year;
        }

        @Override
        public String toString ()
        {
            return "" +
                    "id='" + id + '\'' +
                    "brand='" + brand + '\'' +
                    ", model='" + model + '\'' +
                    ", year=" + year +
                    ' ';
        }



}