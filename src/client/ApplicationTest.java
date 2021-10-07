package client;

import bus.*;

import java.util.Scanner;

public class ApplicationTest {

    // Creating new Vehicles
    // Vehicle vehicle1 = new Vehicle();
    // Vehicle vehicle2 = new Vehicle(10, 1.0, "X0001", (short) 10, "1991");

    // Creating new Electric Vehicles
    // ElectricVehicle electricVehicle2 = new ElectricVehicle();
    // ElectricVehicle electricVehicle1 = new ElectricVehicle(20, 2.0, "X0002", (short) 20, "1992");

    // Creating new Gas Vehicles
    // GasVehicle gasVehicle1 = new GasVehicle();
    // GasVehicle gasVehicle2 = new GasVehicle(30, 3.0, "X0003", (short) 20, "1993");

    // Add all types to array list Function
    public static void add(Scanner scanner, Vehicle vehicle)
    {
        if (vehicle.getType() == EnumType.GasVehicle)
        {
            GasVehicle gasVehicle = new GasVehicle();
            gasVehicle = (GasVehicle) vehicle; // Down-Casting: taking object of the superclass, and convert it to subclass

            System.out.println("Serial Number? ");
            gasVehicle.setSerialNumber(scanner.next());

            System.out.println("Trip Counter? ");
            gasVehicle.setTripCounter(scanner.nextInt());

            System.out.println("Gas Consumed? ");
            gasVehicle.setEnergyConsumed(scanner.nextDouble());

            System.out.println("Model? ");
            gasVehicle.setModel(scanner.nextShort());

            System.out.println("Made? ");
            gasVehicle.setMade(scanner.next());

            // Adding to data collection
            DataCollection.add(gasVehicle);
        }
        else if (vehicle.getType() == EnumType.ElectricVehicle)
        {
            ElectricVehicle electricVehicle = new ElectricVehicle();
            electricVehicle = (ElectricVehicle) vehicle;

            System.out.println("Serial Number? ");
            electricVehicle.setSerialNumber(scanner.next());

            System.out.println("Trip Counter? ");
            electricVehicle.setTripCounter(scanner.nextInt());

            System.out.println("Gas Consumed? ");
            electricVehicle.setEnergyConsumed(scanner.nextDouble());

            System.out.println("Model? ");
            electricVehicle.setModel(scanner.nextShort());

            System.out.println("Made? ");
            electricVehicle.setMade(scanner.next());

            // Adding to data collection
            DataCollection.add(electricVehicle);
        }
    }

    // Loading Data Function
    public static void loadData(Scanner scanner) // scanner is the formal parameter
    {
        int option = 0;
        int keepLooping = 0;
        GasVehicle gasVehicle = null;
        ElectricVehicle electricVehicle = null;

        do
        {
            // User Input
            System.out.print("What type of counter? [Type 1: Gas Vehicle / Type 2: Electric Vehicle] ");
            option = scanner.nextInt();

            // Menu of selections
            switch (option)
            {
                case 1:
                    gasVehicle = new GasVehicle();
                    gasVehicle.setType(EnumType.GasVehicle);
                    add(scanner, gasVehicle);
                    break;

                case 2:
                    electricVehicle = new ElectricVehicle();
                    electricVehicle.setType(EnumType.ElectricVehicle);
                    add(scanner, electricVehicle);
                    break;
            }
            System.out.print("Continue? [1-to continue / 0- to exit] ");
            keepLooping = scanner.nextInt();


        }while(keepLooping == 1);
    }

    // Print Data Function
    public static void printData()
    {
        System.out.println("List of Vehicles");

        for(Vehicle item : DataCollection.getListOfVehicle())
        {
            System.out.println("Item: " + item);
        }
    }

    // MAIN Function
    public static void main(String[] args){

        // Initiate scan
        Scanner scanner = new Scanner(System.in);

        // Load data during run-time
        // Loading data from user
        loadData(scanner);

        // Print Data
        printData();

        // End of application
        System.out.println("End of application");
        scanner.close();
        System.exit(0);
    }
}
