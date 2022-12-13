import models.interfaces.Vehicle;
import models.manufacturer.ManufacturerImpl;
import models.vehicle.Boat;
import models.vehicle.Car;
import models.vehicle.Motorbike;
import models.vehicle.Truck;

import java.math.BigDecimal;
import java.util.ArrayList;

public class VehicleExchange {
    private ArrayList<Vehicle> vehicleList = new ArrayList<>();

    public ArrayList<Vehicle> getVehicleList(){
        ArrayList<Vehicle> vehicleListCopy = new ArrayList(vehicleList);

        return vehicleListCopy;
    }

    public boolean addVehicle(Vehicle vehicle) {
        if (!vehicleList.contains(vehicle)) {
            return vehicleList.add(vehicle);
        }

        return false;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        if (vehicleList.contains(vehicle)) {
            return vehicleList.remove(vehicle);
        }

        return false;
    }

//    public boolean update(Vehicle vehicle, int index){
//        if(vehicleList.get(index) != null){
//            vehicleList.set(index, vehicle);
//
//            return true;
//        }
//
//        return false;
//    }
    
    public void exitProgram() {
        System.exit(0);
    }

    public void dummy() {
        Boat boat = new Boat("Schnellboot", new ManufacturerImpl("Boothersteller"), 2000, "Rot", BigDecimal.valueOf(20000.50));
        Car car = new Car("Schnellauto", new ManufacturerImpl("Opel"), 1979, "Blau", BigDecimal.valueOf(7999.56));
        Motorbike motorbike = new Motorbike("Schnellmoped", new ManufacturerImpl("Simson"), 1912, "Weiss", BigDecimal.valueOf(1273.88));
        Truck truck = new Truck("Schnelltruck", new ManufacturerImpl("Deutz"), 1933, "Gruen", BigDecimal.valueOf(1500));
        addVehicle(boat);
        addVehicle(car);
        addVehicle(motorbike);
        addVehicle(truck);
    }
}
