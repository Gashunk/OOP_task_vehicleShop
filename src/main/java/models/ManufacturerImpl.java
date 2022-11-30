package models;

import models.interfaces.Manufacturer;

public class ManufacturerImpl implements Manufacturer {
    String name;

    public ManufacturerImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
