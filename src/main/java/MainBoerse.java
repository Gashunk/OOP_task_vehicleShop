import java.util.Date;
import java.util.Scanner;

public class MainBoerse {
    private VehicleExchange vehicleExchange;
    private Scanner scanner = new Scanner(System.in);

    public MainBoerse(VehicleExchange vehicleExchange) {
        this.vehicleExchange = vehicleExchange;
    }

    public void hauptMenue() {
        showMenu(1);
        System.out.println("""
                1) Fahrzeug anlegen
                2) Fahrzeug bearbeiten
                3) Fahrzeug suchen
                4) Fahrzeug löschen
                0) Börse beenden
                ------------------------------------------------------------------------------------------
                Bitte wählen:""");

        int input = checkInt();
        switch (input) {
            case 1:
                createVehicle();
                break;

            //case 2: -> fzgBearbeiten();
            //case 3: -> getVehicle();
            //case 4: -> removeVehicle();
            //case 0: -> boerseBeenden();
            default: {
                System.out.println("Falscheingabe, bitte versuchen sie es erneut!");
                hauptMenue();
            }
        }
    }

    public void createVehicle() {
        showMenu(2);

    }

    public int checkInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Bitte nur ganze Zahlen eingeben!");
            }
        }
    }

    public void showMenu(int menuType){
        String menuTitle = "";
        switch (menuType){
            case 1:
                menuTitle = "Hauptmenü";
                break;

            case 2:
                menuTitle = "Fahrzeug anlegen";
                break;
        }

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.format("%-22s%-22s%-20s\n", "Fahrzeugbörse", menuTitle, "von: Lothar Neumann");
        System.out.println("------------------------------------------------------------------------------------------");
    }
}
