package com.study.java.java8.interfaces;

import com.study.java.utils.enums.Color;

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
