package models;

import models.interfaces.Manufacturer;
import models.interfaces.Vehicle;

import java.math.BigDecimal;
import java.util.Date;

public class Motorbike implements Vehicle {
    private String model;
    private Manufacturer manufacturer;
    private Date constructionYear;
    private String color;
    private BigDecimal price;

    public Motorbike(String model, Manufacturer manufacturer, Date constructionYear, String color, BigDecimal price) {
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
    public BigDecimal getPrice() {
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
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
