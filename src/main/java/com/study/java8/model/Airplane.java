package com.study.java8.model;

import com.study.java8.interfaces.Auto;
import com.study.java8.enums.Color;

public class Airplane implements Auto {
    private int maxSpeed;
    private int amountWheels;
    private double weight;
    private Color color;
    private String brand;
    private String model;
    private int places;
    private int warrantyYearsPeriod;

    @Override
    public int maxSpeed() {
        return 0;
    }

    @Override
    public int amountWheels() {
        return 0;
    }

    @Override
    public Color color() {
        return null;
    }

    @Override
    public int amountPlaces() {
        return 0;
    }

    @Override
    public double weight() {
        return 0;
    }

    @Override
    public String brand() {
        return null;
    }

    @Override
    public String model() {
        return null;
    }

    @Override
    public int warrantyYearsPeriod() {
        return warrantyYearsPeriod;
    }

    @Override
    public boolean fly() {
        return true;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setAmountWheels(int amountWheels) {
        this.amountWheels = amountWheels;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public void setWarrantyYearsPeriod(int warrantyYearsPeriod) {
        this.warrantyYearsPeriod = warrantyYearsPeriod;
    }
}
