package com.study.java.models;

import com.study.java.utils.enums.Color;
import com.study.java.java8.interfaces.Auto;

public class Car implements Auto {
    private int id;
    private int maxSpeed;
    private double weight;
    private Color color;
    private String brand;
    private String model;
    private int warrantyYearsPeriod;

    public Car(int id, int maxSpeed, double weight, Color color,
               String brand, String model, int warrantyYearsPeriod) {
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.id = id;
        this.warrantyYearsPeriod = warrantyYearsPeriod;
    }

    @Override
    public int maxSpeed() {
        return maxSpeed;
    }

    @Override
    public int amountWheels() {
        return 4;
    }

    @Override
    public Color color() {
        return color;
    }

    @Override
    public int amountPlaces() {
        return 5;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public String brand() {
        return brand;
    }

    @Override
    public String model() {
        return model;
    }

    @Override
    public int warrantyYearsPeriod() {
        return warrantyYearsPeriod;
    }

    public int getId() {
        return id;
    }

    public void changeColor(Color newColor) {
        color = newColor;
    }
}
