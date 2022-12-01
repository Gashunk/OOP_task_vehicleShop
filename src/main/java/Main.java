import exceptions.VehicleAlreadyExistException;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException, VehicleAlreadyExistException {
        VehicleExchange vehicleExchange = new VehicleExchange();
        MainBoerse mainBoerse = new MainBoerse(vehicleExchange);
        mainBoerse.hauptMenue();
    }
}
