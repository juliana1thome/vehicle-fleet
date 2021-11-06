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
    	Boolean isValid = false;
        if (vehicle.getType() == VehicleType.GasVehicle)
        {
            GasVehicle gasVehicle;
            gasVehicle = (GasVehicle) vehicle; // Down-Casting: taking object of the superclass, and convert it to subclass

            while (!isValid) {
				try {
					System.out.println("Serial Number? ");
					gasVehicle.setSerialNumber(scanner.next());
					isValid = true;
				} catch (EmptyFieldException exception) {
					System.out.println(exception.getMessage());
				}
			}

			isValid = false;

			while (!isValid) {
				try {
					System.out.println("Trip Counter? ");
					gasVehicle.setTripCounter(scanner.nextInt());
					isValid = true;
				} catch (NegativeNumberException | EmptyFieldException exception) {
					System.out.println(exception.getMessage());
				}
			}

			isValid = false;

			while (!isValid) {
				try {
					System.out.println("Gas Consumed? ");
					gasVehicle.setEnergyConsumed(scanner.nextDouble());
					isValid = true;
				} catch (NegativeNumberException | EmptyFieldException exception) {
					System.out.println(exception.getMessage());
				}
			}

			isValid = false;

			while (!isValid) {
				try {
					System.out.println("Model? ");
					gasVehicle.setModel(scanner.nextShort());
					isValid = true;
				} catch (NegativeNumberException | EmptyFieldException exception) {
					System.out.println(exception.getMessage());
				}
			}

			isValid = false;

			while (!isValid) {
				try {
					System.out.println("Made? ");
					gasVehicle.setMade(scanner.next());
					isValid = true;
				} catch (EmptyFieldException exception) {
					System.out.println(exception.getMessage());
				}
			}

			// Adding to data collection
			VehiclesFleet.getSingleInstance().add(gasVehicle);
		} else if (vehicle.getType() == VehicleType.ElectricVehicle) {
			ElectricVehicle electricVehicle;
			electricVehicle = (ElectricVehicle) vehicle;

			while (!isValid) {
				try {
					System.out.println("Serial Number? ");
					electricVehicle.setSerialNumber(scanner.next());
					isValid = true;
				} catch ( EmptyFieldException exception) {
					System.out.println(exception.getMessage());
				}
			}

			isValid = false;
			
			while (!isValid) {
				try {
					System.out.println("Trip Counter? ");
					electricVehicle.setTripCounter(scanner.nextInt());
					isValid = true;
				} catch (NegativeNumberException | EmptyFieldException exception) {
					System.out.println(exception.getMessage());
				}
			}

			isValid = false;

			while (!isValid) {
				try {
					System.out.println("Gas Consumed? ");
					electricVehicle.setEnergyConsumed(scanner.nextDouble());
					isValid = true;
				} catch (NegativeNumberException | EmptyFieldException exception) {
					System.out.println(exception.getMessage());
				}
			}

			isValid = false;

			while (!isValid) {
				try {
					System.out.println("Model? ");
					electricVehicle.setModel(scanner.nextShort());
					isValid = true;
				} catch (NegativeNumberException | EmptyFieldException exception) {
					System.out.println(exception.getMessage());
				}
			}

			isValid = false;

			while (!isValid) {
				try {
					System.out.println("Made? ");
					electricVehicle.setMade(scanner.next());
					isValid = true;
				} catch (EmptyFieldException exception) {
					System.out.println(exception.getMessage());
				}
			}		


            // Adding to data collection
            VehiclesFleet.getSingleInstance().add(electricVehicle);
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
                    gasVehicle.setType(VehicleType.GasVehicle);
                    add(scanner, gasVehicle);
                    break;

                case 2:
                    electricVehicle = new ElectricVehicle();
                    electricVehicle.setType(VehicleType.ElectricVehicle);
                    add(scanner, electricVehicle);
                    break;
            }
            System.out.print("Continue? [1-to continue / 0- to exit] ");
            keepLooping = scanner.nextInt();


        }while(keepLooping == 1);
    }

	// MAIN Function
	public static void main(String[] args){

		// Initiate scan
		Scanner scanner = new Scanner(System.in);

		// Load data during run-time
		// Loading data from user
		loadData(scanner);

		// Search by Serial Number
		System.out.println("\n------------------------------------------------------");
		System.out.println("Search a Vehicle by its serial number: ");
		VehiclesFleet.getSingleInstance().searchBySerialNumber(scanner.next());

		// Print Data By Vehicle Type
		// By Gas Vehicle
		System.out.println("\n------------------------------------------------------");
		System.out.println("Printing only Gas vehicles, before sorting:");
		VehiclesFleet.getSingleInstance().printGasVehicles();

		// By Electric Vehicle
		System.out.println("\n------------------------------------------------------\n");
		System.out.println("Printing only Electric vehicles, before sorting:");
		VehiclesFleet.getSingleInstance().printElectricVehicles();


		// Print Data Before Sorting
		System.out.println("\n------------------------------------------------------");
		System.out.println("Printing the entire fleet of vehicles, before sorting:");
		VehiclesFleet.getSingleInstance().print();

		// Print Data Before Sorting by Mileage Efficiency
		System.out.println("\n------------------------------------------------------");
		System.out.println("Printing vehicles, after sorting by Mileage Efficiency (Decreasing): ");
		VehiclesFleet.getSingleInstance().sortByMileageEfficiency();
		VehiclesFleet.getSingleInstance().print();

		// Print Data Before Sorting by Serial Number
		System.out.println("\n------------------------------------------------------");
		System.out.println("Printing vehicles, after sorting by Serial Number and depending on its type (Increasing): ");
		VehiclesFleet.getSingleInstance().sortBySerialNumber();
		VehiclesFleet.getSingleInstance().print();


		// End of application
		System.out.println("End of application");
		scanner.close();
		System.exit(0);
    }
}
