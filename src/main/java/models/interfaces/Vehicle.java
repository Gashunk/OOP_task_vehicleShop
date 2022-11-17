package models.interfaces;

import java.util.Date;

public interface Vehicle {
    Manufacturer getManufacturer();
    String getModel();
    Date getConstructionYear();
    String getColor();
    double getPrice();
}
