package client;

import bus.*;
import data.ElectricVehicleDB;
import data.GasVehicleDB;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationTest {

	// Creating new Vehicles
	// Vehicle vehicle1 = new Vehicle();
	// Vehicle vehicle2 = new Vehicle(10, 1.0, "X0001", (short) 10, "1991");

	// Creating new Electric Vehicles
	// ElectricVehicle electricVehicle2 = new ElectricVehicle();
	// ElectricVehicle electricVehicle1 = new ElectricVehicle(20, 2.0, "X0002",
	// (short) 20, "1992");

	// Creating new Gas Vehicles
	// GasVehicle gasVehicle1 = new GasVehicle();
	// GasVehicle gasVehicle2 = new GasVehicle(30, 3.0, "X0003", (short) 20,
	// "1993");

	// Add all types to array list Function
	public static void add(Scanner scanner, Vehicle vehicle) {
		Boolean isValid = false;
		if (vehicle.getType() == VehicleType.GasVehicle) {
			GasVehicle gasVehicle;
			gasVehicle = (GasVehicle) vehicle; // Down-Casting: taking object of the superclass, and convert it to
												// subclass

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
			SingletonVehiclesFleet.getSingleInstance().add(gasVehicle);
		} else if (vehicle.getType() == VehicleType.ElectricVehicle) {
			ElectricVehicle electricVehicle;
			electricVehicle = (ElectricVehicle) vehicle;

			while (!isValid) {
				try {
					System.out.println("Serial Number? ");
					electricVehicle.setSerialNumber(scanner.next());
					isValid = true;
				} catch (EmptyFieldException exception) {
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
			SingletonVehiclesFleet.getSingleInstance().add(electricVehicle);
		}
	}

	// Loading Data Function
	public static void loadData(Scanner scanner) // scanner is the formal parameter
	{
		int option = 0;
		int keepLooping = 0;
		GasVehicle gasVehicle = null;
		ElectricVehicle electricVehicle = null;

		do {
			// User Input
			System.out.print("What type of counter? [Type 1: Gas Vehicle / Type 2: Electric Vehicle] ");
			option = scanner.nextInt();

			// Menu of selections
			switch (option) {
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

		} while (keepLooping == 1);
	}

	// MAIN Function
	public static void main(String[] args) {

		// Initiate scan
		Scanner scanner = new Scanner(System.in);

		// Load data during run-time
		// Loading data from user
		loadData(scanner);

		// Search by Serial Number
		System.out.println("\n------------------------------------------------------");
		System.out.println("Search a Vehicle by its serial number: ");
		SingletonVehiclesFleet.getSingleInstance().searchBySerialNumber(scanner.next());

		// Print Data By Vehicle Type
		// By Gas Vehicle
		System.out.println("\n------------------------------------------------------");
		System.out.println("Printing only Gas vehicles, before sorting:");
		SingletonVehiclesFleet.getSingleInstance().printGasVehicles();

		// By Electric Vehicle
		System.out.println("\n------------------------------------------------------\n");
		System.out.println("Printing only Electric vehicles, before sorting:");
		SingletonVehiclesFleet.getSingleInstance().printElectricVehicles();


		// Print Data Before Sorting
		System.out.println("\n------------------------------------------------------");
		System.out.println("Printing the entire fleet of vehicles, before sorting:");
		SingletonVehiclesFleet.getSingleInstance().print();

		// Print Data Before Sorting by Mileage Efficiency
		System.out.println("\n------------------------------------------------------");
		System.out.println("Printing vehicles, after sorting by Mileage Efficiency (Decreasing): ");
		SingletonVehiclesFleet.getSingleInstance().sortByMileageEfficiency();
		SingletonVehiclesFleet.getSingleInstance().print();

		// Print Data Before Sorting by Serial Number
		System.out.println("\n------------------------------------------------------");
		System.out.println("Printing vehicles, after sorting by Serial Number and depending on its type (Increasing): ");
		SingletonVehiclesFleet.getSingleInstance().sortBySerialNumber();
		SingletonVehiclesFleet.getSingleInstance().print();

		// Serializing final vehicle list
		System.out.println("\n------------------------------------------------------");
		System.out.println("Serializing final vehicle list... ");
		try {
			SingletonVehiclesFleet.getSingleInstance().Serialized();
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}

		// Connecting and saving in DB
		System.out.println("\n------------------------------------------------------");
		System.out.println("DB Inserting row");
		try {
			ElectricVehicle electricVehicle1 = new ElectricVehicle(20, 2.0, "X0002", (short) 20, "1992");
			ElectricVehicleDB.insert(electricVehicle1);
		} catch (NegativeNumberException | EmptyFieldException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Deleting the electric vehicle from DB
		System.out.println("\n------------------------------------------------------");
		System.out.println("DB Deleting row");
		try {
			ElectricVehicleDB.delete("X0002");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Extracting electric vehicles from DB
		System.out.println("\n------------------------------------------------------");
		System.out.println("DB Selecting all rows from ElectricVehicle");
		ArrayList<ElectricVehicle> electricList = new ArrayList<ElectricVehicle>();
		try {
			electricList = ElectricVehicleDB.select();
		} catch (NumberFormatException | SQLException | NegativeNumberException | EmptyFieldException e) {
			e.printStackTrace();
		}

		for (Vehicle ev : electricList) {
			System.out.println(ev.toString());
		}

		// Search from DB
		System.out.println("\n------------------------------------------------------");
		System.out.println("DB Search one row from ElectricVehicle");
		ElectricVehicle v1 = new ElectricVehicle();
		try {
			v1 = ElectricVehicleDB.search("Chevy");
			System.out.println(v1);
		} catch (NumberFormatException | SQLException | NegativeNumberException | EmptyFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Update from DB
		if (v1 != null) {
			try {
				v1.setTripCounter(50);
			} catch (NegativeNumberException | EmptyFieldException e) {
				e.printStackTrace();
			}
			
			System.out.println("\n------------------------------------------------------");
			System.out.println("DB Update one column from a row from ElectricVehicle");
			try {
				ElectricVehicleDB.update(v1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// End of application
		System.out.println("End of application");
		scanner.close();
		System.exit(0);
	}
}
