import exceptions.VehicleAlreadyExistException;
import exceptions.VehicleNotFound;
import models.interfaces.Vehicle;

import java.util.ArrayList;

public class VehicleExchange {
    private ArrayList<Vehicle> vehicleList = new ArrayList<>();

    public ArrayList<Vehicle> getVehicleList(){
        ArrayList<Vehicle> vehicleListCopy = new ArrayList(vehicleList);

        return vehicleListCopy;
    }

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

    public boolean update(Vehicle vehicle, int index){
        if(vehicleList.get(index) != null){
            vehicleList.set(index, vehicle);
            
            return true;
        }

        return false;
    }
    
    public void exitProgram() {
        System.exit(0);
    }
}
