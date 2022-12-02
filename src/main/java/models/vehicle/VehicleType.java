package models.vehicle;

public enum VehicleType {
    CAR("Pkw"),
    TRUCK("Lkw"),
    MOTORBIKE("Motorrad"),
    BOAT("Boot");

    private String name;

    VehicleType(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
