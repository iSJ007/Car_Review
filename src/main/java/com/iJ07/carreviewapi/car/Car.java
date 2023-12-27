package com.iJ07.carreviewapi.car;


public class Car {

    public Integer car_id;
    public String make;
    public String model;
    public String body_type;
    public String engine;
    public String transmission;
    public String drivetrain;
    public Integer passengers;
    public Integer doors;
    public String fuel_type;
    public Float city_mpg;
    public Float highway_mpg;
    public Double price;

    // Constructor
    public Car(Integer car_id, String make, String model, String body_type, String engine,
               String transmission, String drivetrain, Integer passengers, Integer doors,
               String fuel_type, Float city_mpg, Float highway_mpg, Double price) {
        this.car_id = car_id;
        this.make = make;
        this.model = model;
        this.body_type = body_type;
        this.engine = engine;
        this.transmission = transmission;
        this.drivetrain = drivetrain;
        this.passengers = passengers;
        this.doors = doors;
        this.fuel_type = fuel_type;
        this.city_mpg = city_mpg;
        this.highway_mpg = highway_mpg;
        this.price = price;
    }

    // Getter methods
    public Integer getCarId() {
        return car_id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getBodyType() {
        return body_type;
    }

    public String getEngine() {
        return engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getDrivetrain() {
        return drivetrain;
    }

    public Integer getPassengers() {
        return passengers;
    }

    public Integer getDoors() {
        return doors;
    }

    public String getFuelType() {
        return fuel_type;
    }

    public Float getCityMpg() {
        return city_mpg;
    }

    public Float getHighwayMpg() {
        return highway_mpg;
    }

    public Double getPrice() {
        return price;
    }
}

