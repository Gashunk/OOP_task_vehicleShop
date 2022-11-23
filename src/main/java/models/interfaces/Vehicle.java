package models.interfaces;

import java.util.Date;

public interface Vehicle {
    Manufacturer getManufacturer();
    String getModel();
    Date getConstructionYear();
    String getColor();
    double getPrice();
    void setManufacturer(Manufacturer manufacturer);
    void setModel(String model);
    void setConstructionYear(Date constructionYear);
    void setColor(String color);
    void setPrice(double price);
}
