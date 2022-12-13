import models.interfaces.Vehicle;
import models.manufacturer.ManufacturerImpl;
import models.vehicle.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class MainBoerse {
    private VehicleExchange vehicleExchange;
    private Scanner scanner = new Scanner(System.in);

    public MainBoerse(VehicleExchange vehicleExchange) {
        this.vehicleExchange = vehicleExchange;
    }

    public void hauptMenue() throws ParseException {
        showMenu(1);
        System.out.println("""
                1) Fahrzeug anlegen
                2) Fahrzeug bearbeiten
                3) Fahrzeug suchen
                4) Fahrzeug löschen
                5) Fahrzeugdummy anlegen
                0) Börse beenden
                ---------------------------------------------------------------------------------------------------------------------------------------------------
                Bitte wählen:""");

        int input = checkInt();
        switch (input) {
            case 1:
                createVehicle();
                hauptMenue();
                break;

            case 2:
                updateVehicle();
                hauptMenue();
                break;

            case 3:
                getVehicle();
                hauptMenue();
                break;

            case 4:
                deleteVehicle();
                hauptMenue();
                break;

            case 5:
                vehicleExchange.dummy();
                hauptMenue();
                break;

            case 0:
                exit();
                break;

            default: {
                System.out.println("Falscheingabe, bitte versuchen sie es erneut!");
                hauptMenue();
            }
        }
    }

    public void createVehicle() throws ParseException {
        showMenu(2);

        System.out.println("""
                Wählen sie ein Fahrzeugtyp aus:
                1) Pkw
                2) Lkw
                3) Motorrad
                4) Boot
                0) zurück zum Hauptmenü
                ---------------------------------------------------------------------------------------------------------------------------------------------------
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

//        System.out.println("Sind ihre Eingaben korrekt?");
//        System.out.println("Fahrzeugtyp: " + vehicleTypeName
//        + "\nHersteller: " + manufacturer.getName()
//        + "\nModell: " + model
//        + "\nBaujahr: " + constructionYear
//        + "\nFarbe: " + color
//        + "\nPreis: " + price);


        switch (vehicleType) {
            case 1 -> vehicleExchange.addVehicle(new Car(model, manufacturer, constructionYear, color, price));
            case 2 -> vehicleExchange.addVehicle(new Truck(model, manufacturer, constructionYear, color, price));
            case 3 -> vehicleExchange.addVehicle(new Motorbike(model, manufacturer, constructionYear, color, price));
            case 4 -> vehicleExchange.addVehicle(new Boat(model, manufacturer, constructionYear, color, price));
        }
    }

    public void updateVehicle() throws ParseException {
        showMenu(3);
        printVehicles(vehicleExchange.getVehicleList());

        System.out.println("Welches Fahrzeug wollen sie bearbeiten? Bitte geben sie die Laufnummer ein: ");
        int updateIndex = checkInt();

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

        vehicleExchange.getVehicleList().get(updateIndex).setManufacturer(manufacturer);
        vehicleExchange.getVehicleList().get(updateIndex).setModel(model);
        vehicleExchange.getVehicleList().get(updateIndex).setConstructionYear(constructionYear);
        vehicleExchange.getVehicleList().get(updateIndex).setColor(color);
        vehicleExchange.getVehicleList().get(updateIndex).setPrice(price);
    }

    public void getVehicle() throws ParseException {
        showMenu(4);

        System.out.println("Geben sie einen Suchbegriff ein: ");
        String input = checkString();

        printVehicles(searchVehicleList(input));
    }

    public ArrayList<Vehicle> searchVehicleList(String input) {
        ArrayList<Vehicle> searchList = new ArrayList<>();

        for (int index = 0; index < vehicleExchange.getVehicleList().size(); index++) {
            if (vehicleExchange.getVehicleList().get(index).getVehicleType().equals(input)
                    || vehicleExchange.getVehicleList().get(index).getColor().equals(input)
                    || vehicleExchange.getVehicleList().get(index).getManufacturer().getName().equals(input)
                    || vehicleExchange.getVehicleList().get(index).getModel().equals(input)
                    || vehicleExchange.getVehicleList().get(index).getVehicleType().equals(input)
                    || String.valueOf(vehicleExchange.getVehicleList().get(index).getConstructionYear()).equals(input)
                    || String.valueOf(vehicleExchange.getVehicleList().get(index).getPrice()).equals(input)) {
                searchList.add(vehicleExchange.getVehicleList().get(index));
            }
        }

        return searchList;
    }

    public void deleteVehicle() throws ParseException {
        showMenu(5);
        printVehicles(vehicleExchange.getVehicleList());

        System.out.println("Geben sie die zu löschende Laufnummer ein: ");
        int deleteIndex = checkInt();

        System.out.println("Sind sie sicher, dass sie die Laufnummer " + deleteIndex + " löschen wollen? j/n");
        String approval = checkString().toLowerCase();

        if (approval.equals("j")){
           vehicleExchange.removeVehicle(vehicleExchange.getVehicleList().get(deleteIndex));
        } else {
            System.out.println("Hauptmenü wird angezeigt.");
            hauptMenue();
        }
    }

    public void exit() throws ParseException {
        System.out.println("Sind sie sicher? j/n");
        String input = checkString().toLowerCase();

        if(input.equals("j")){
            vehicleExchange.exitProgram();
        } else {
            hauptMenue();
        }
    }

    public void printVehicles(ArrayList<Vehicle> printList) {

        System.out.format("| %-18s | %-18s | %-18s | %-18s | %-18s | %-18s| %-18s |\n",
                "Laufnummer",
                "Modell",
                "Fahrzeugtyp",
                "Hersteller",
                "Baujahr",
                "Farbe",
                "Preis");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");

        for (int index = 0; index < printList.size(); index++) {
            System.out.format("| %-18s | %-18s | %-18s | %-18s | %-18s | %-18s| %-18s |\n",
                    index,
                    printList.get(index).getModel(),
                    printList.get(index).getVehicleType(),
                    printList.get(index).getManufacturer().getName(),
                    printList.get(index).getConstructionYear(),
                    printList.get(index).getColor(),
                    printList.get(index).getPrice());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void showMenu(int menuType) {
        String menuTitle = switch (menuType) {
            case 1 -> "Hauptmenue";
            case 2 -> "Fahrzeug anlegen";
            case 3 -> "Fahrzeug bearbeiten";
            case 4 -> "Fahrzeug suchen";
            case 5 -> "Fahrzeug loeschen";
            case 6 -> "Boerse beenden";
            default -> "";
        };

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %-22s%-22s%-100s |\n", "Fahrzeugbörse", menuTitle, "von: Lothar Neumann");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public int checkInt() throws ParseException {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Bitte nur ganze Zahlen eingeben!");
                hauptMenue();
            }
        }
    }

    public String checkString() throws ParseException {
        while (true) {
            String input = scanner.nextLine();

            String output = input.replace("ü", "ue")
                    .replace("ö", "oe")
                    .replace("ä", "ae")
                    .replace("ß", "ss");

            output = output.replaceAll("Ü(?=[a-zäöüß ])", "Ue")
                    .replaceAll("Ö(?=[a-zäöüß ])", "Oe")
                    .replaceAll("Ä(?=[a-zäöüß ])", "Ae");

            output = output.replace("Ü", "UE")
                    .replace("Ö", "OE")
                    .replace("Ä", "AE");

            if (output.isEmpty()) {
                System.out.println("Falscheingabe, es wird ins Hauptmenü zurückgekehrt!");
                hauptMenue();
            } else {
                return output;
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

//    public void assmus() throws VehicleAlreadyExistException, ParseException {
//        System.out.println("Falscheingabe");
//        hauptMenue();
//    }
}
