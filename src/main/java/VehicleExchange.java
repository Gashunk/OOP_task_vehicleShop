import exceptions.VehicleAlreadyExistException;
import exceptions.VehicleNotFound;
import models.interfaces.Vehicle;

import java.util.ArrayList;

public class VehicleExchange {
    private ArrayList<Vehicle> vehicleList = new ArrayList<>();

    public boolean addVehicle(Vehicle vehicle) throws VehicleAlreadyExistException {
        if (!vehicleList.contains(vehicle)) {
            return vehicleList.add(vehicle);
        }

        throw new VehicleAlreadyExistException();
    }

    public boolean removeVehicle(Vehicle vehicle) throws VehicleNotFound {
        if (vehicleList.contains(vehicle)) {
            return vehicleList.remove(vehicle);
        }

        throw new VehicleNotFound();
    }
    
    public void boerseBeenden() {
        System.exit(0);
    }
}
