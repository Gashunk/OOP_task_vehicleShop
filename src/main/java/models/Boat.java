package models;

import models.interfaces.Manufacturer;
import models.interfaces.Vehicle;

import java.util.Date;

public class Boat implements Vehicle {
    private String brand;
    private String model;
    private Manufacturer manufacturer;
    private Date constructionYear;
    private String color;
    private double price;

    public Boat(String brand, String model, Manufacturer manufacturer, Date constructionYear, String color, double price) {
        this.brand = brand;
        this.model = model;
        this.manufacturer = manufacturer;
        this.constructionYear = constructionYear;
        this.color = color;
        this.price = price;
    }

    @Override
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public Date getConstructionYear() {
        return constructionYear;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
