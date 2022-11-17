import exceptions.VehicleAlreadyExistException;
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

    public boolean fzgBearbeiten(){
        return true;
    }

    public void boerseBeenden(){
        System.exit(0);
    }
}
