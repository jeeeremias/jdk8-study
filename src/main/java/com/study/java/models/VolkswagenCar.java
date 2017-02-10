package com.study.java.models;

public class VolkswagenCar extends Car{
    public VolkswagenCar(Car car) {
        super(car.getId(), car.maxSpeed(), car.weight(),
                car.color(), car.brand(), car.model(), 15);
    }
}
