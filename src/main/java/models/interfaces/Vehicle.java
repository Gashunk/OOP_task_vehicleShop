package models.interfaces;

import java.math.BigDecimal;
import java.util.Date;

public interface Vehicle {
    Manufacturer getManufacturer();
    String getModel();
    Date getConstructionYear();
    String getColor();
    BigDecimal getPrice();

    void setManufacturer(Manufacturer manufacturer);
    void setModel(String model);
    void setConstructionYear(Date constructionYear);
    void setColor(String color);
    void setPrice(BigDecimal price);
}
