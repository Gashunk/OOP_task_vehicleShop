package models;

import models.interfaces.Manufacturer;
import models.interfaces.Vehicle;

import java.util.Date;

public class Car implements Vehicle {
    private String brand;
    private String model;
    private Manufacturer manufacturer;
    private Date constructionYear;
    private String color;
    private double price;

    public Car(String brand, String model, Manufacturer manufacturer, Date constructionYear, String color, double price) {
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

    @Override
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void setConstructionYear(Date constructionYear) {
        this.constructionYear = constructionYear;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}
