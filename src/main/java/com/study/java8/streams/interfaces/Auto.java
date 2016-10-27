package com.study.java8.streams.interfaces;

import com.study.java8.streams.enums.Color;

public interface Auto {
    int maxSpeed();
    int amountWheels();
    Color color();
    int amountPlaces();
    double weight();
    String brand();
    String model();
    int warrantyYearsPeriod();
    default boolean fly() {
        return false;
    }
}
