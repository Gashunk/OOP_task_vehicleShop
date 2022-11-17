import exceptions.VehicleAlreadyExistException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import models.interfaces.Vehicle;

public class VehicleExchanceTest {

    @Test
    public void addVehicle_Success() throws VehicleAlreadyExistException {
        Vehicle vehicle = Mockito.mock(Vehicle.class);

        VehicleExchange vehicleExchange = new VehicleExchange();

        boolean result = vehicleExchange.addVehicle(vehicle);

        Assertions.assertTrue(result);
    }

    @Test
    public void addVehicle_VehicleAlreadyExistException(){
        Vehicle vehicle = Mockito.mock(Vehicle.class);

        VehicleExchange vehicleExchange = new VehicleExchange();

        Assertions.assertThrows(VehicleAlreadyExistException.class, () ->{
            vehicleExchange.addVehicle(vehicle);
            vehicleExchange.addVehicle(vehicle);
        });
    }
}
