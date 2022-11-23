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

    public void update(Vehicle vehicle, int index){
        if(vehicleList.get(index) != null){
            vehicleList.get(index).setManufacturer(vehicle.getManufacturer());
            vehicleList.get(index).setModel(vehicle.getModel());
            vehicleList.get(index).setConstructionYear(vehicle.getConstructionYear());
            vehicleList.get(index).setColor(vehicle.getColor());
            vehicleList.get(index).setPrice(vehicle.getPrice());
        }
    }
    
    public void boerseBeenden() {
        System.exit(0);
    }
}
