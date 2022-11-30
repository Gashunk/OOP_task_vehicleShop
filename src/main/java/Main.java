public class Main {
    public static void main(String[] args) {
        VehicleExchange vehicleExchange = new VehicleExchange();
        MainBoerse mainBoerse = new MainBoerse(vehicleExchange);
        mainBoerse.hauptMenue();
    }
}
