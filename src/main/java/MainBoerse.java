import java.util.Date;

public class MainBoerse {

    public static void main(String[] args) {
        VehicleExchange vehicleExchange = new VehicleExchange();
        hauptMenue();
    }

    public static void hauptMenue() {
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.format("%-22s%-15s%-20s\n", "Fahrzeugbörse", "Hauptmenü", "von: Lothar Neumann");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("""
                1) Fahrzeug anlegen
                2) Fahrzeug bearbeiten
                3) Fahrzeug suchen
                4) Fahrzeug löschen
                0) Börse beenden
                ------------------------------------------------------------------------------------------
                Bitte wählen:""");

        String choice = null;
        switch (choice) {
            //case 1: -> fzgAnlegen();
            //case 2: -> fzgBearbeiten();
            //case 3: -> getVehicle();
            //case 4: -> removeVehicle();
            //case 0: -> boerseBeenden();
            default -> {
                System.out.println("Falscheingabe, bitte versuchen sie es erneut!");
                hauptMenue();
            }
        }
    }

    public void createVehicle(){

    }
}
