package models.interfaces;

import java.math.BigDecimal;
import java.util.Date;

public interface Vehicle {
    Manufacturer getManufacturer();
    String getModel();
    int getConstructionYear();
    String getColor();
    BigDecimal getPrice();
    String getVehicleType();

    void setManufacturer(Manufacturer manufacturer);
    void setModel(String model);
    void setConstructionYear(int constructionYear);
    void setColor(String color);
    void setPrice(BigDecimal price);
}
