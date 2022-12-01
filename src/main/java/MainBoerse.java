import exceptions.VehicleAlreadyExistException;
import models.vehicle.Car;
import models.manufacturer.ManufacturerImpl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Scanner;

public class MainBoerse {
    private VehicleExchange vehicleExchange;
    private Scanner scanner = new Scanner(System.in);

    public MainBoerse(VehicleExchange vehicleExchange) {
        this.vehicleExchange = vehicleExchange;
    }

    public void hauptMenue() throws ParseException, VehicleAlreadyExistException {
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

    public void createVehicle() throws ParseException, VehicleAlreadyExistException {
        showMenu(2);

        System.out.println("""
                Wählen sie ein Fahrzeugtyp aus:
                1) Pkw
                2) Lkw
                3) Motorrad
                4) Boot
                0) zurück zum Hauptmenü
                ------------------------------------------------------------------------------------------
                Bitte wählen:""");

        int vehicleType = checkInt();

        if (vehicleType == 0 || vehicleType > 4 || vehicleType < 0) {
            hauptMenue();
        }

        System.out.println("Geben sie den Hersteller ein!");
        ManufacturerImpl manufacturer = new ManufacturerImpl(checkString());

        System.out.println("Geben sie den Namen des Modells ein!");
        String model = checkString();

        System.out.println("Geben sie das Baujahr ein (YYYY).");
        int constructionYear = checkInt();


        System.out.println("Geben sie die Farbe ein!");
        String color = checkString();

        System.out.println("Geben sie den Preis ein!");
        BigDecimal price = checkBigDecimal();

        if(model.isEmpty() || manufacturer.getName().isEmpty() || constructionYear == null ||)
        System.out.println("Sind ihre Eingaben ");

        switch (vehicleType){
            case 1:

                vehicleExchange.addVehicle(new Car(model, manufacturer, constructionYear, color, price));
        }
    }

    public void showMenu(int menuType) {
        String menuTitle = switch (menuType) {
            case 1 -> "Hauptmenü";
            case 2 -> "Fahrzeug anlegen";
            case 3 -> "Fahrzeug suchen";
            case 4 -> "Fahrzeug löschen";
            case 5 -> "Börse beenden";
            default -> "";
        };

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.format("%-22s%-22s%-20s\n", "Fahrzeugbörse", menuTitle, "von: Lothar Neumann");
        System.out.println("------------------------------------------------------------------------------------------");
    }

    public int checkInt() throws VehicleAlreadyExistException, ParseException {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Bitte nur ganze Zahlen eingeben!");
                hauptMenue();
            }
        }
    }

    public String checkString() throws ParseException, VehicleAlreadyExistException {
        while (true) {
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                System.out.println("Falscheingabe, es wird ins Hauptmenü zurückgekehrt!");
                hauptMenue();
            } else {
                return input;
            }
        }
    }

    public BigDecimal checkBigDecimal() {
        while (true) {
            try {
                return BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));
            } catch (NumberFormatException exception) {
                System.out.println("Bitte eine Fließkommazahl eingeben!");
            }
        }
    }

    public void assmus(){
        System.out.println("Falscheingabe");
        hauptMenue();
    }
}
