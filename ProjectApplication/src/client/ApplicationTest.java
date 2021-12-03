package client;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import bus.ElectricVehicle;
import bus.EmptyFieldException;
import bus.GasVehicle;
import bus.NegativeNumberException;
import bus.SingletonDBConnection;
import bus.SingletonVehiclesFleet;
import bus.Vehicle;
import bus.VehicleType;

public class ApplicationTest {
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
					System.out.println("Energy Consumed? ");
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
			System.out.print("What type of counter? [Type 1: Gas Vehicle / Type 2: Electric Vehicle] / [0- to exit] ");
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

		// Warning user that it cannot add more vehicles from now
		System.out.println("\n------------------------------------------------------");
		System.out.println("End of Vehicles creation");

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
		System.out
				.println("Printing vehicles, after sorting by Serial Number and depending on its type (Increasing): ");
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
		System.out.println("Database Inserting row");
		try {
			for (Vehicle vehicle : SingletonVehiclesFleet.getSingleInstance().getListOfVehicle()) {
				SingletonDBConnection.GetInstance().insert(vehicle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Extracting electric vehicles from DB
		System.out.println("\n------------------------------------------------------");
		System.out.println("Database Selecting all rows from ElectricVehicle and GasVehicle");

		ArrayList<Vehicle> vehiclesList = new ArrayList<Vehicle>();

		try {
			vehiclesList = SingletonDBConnection.GetInstance().select();
		} catch (NumberFormatException | SQLException | NegativeNumberException | EmptyFieldException e) {
			e.printStackTrace();
		}

		System.out.println("\n All Vehicles in the Database");
		for (Vehicle vehicle : vehiclesList) {
			System.out.println(vehicle.toString());
			SingletonVehiclesFleet.getSingleInstance().add(vehicle);
		}

		// Search from DB
		System.out.println("\n------------------------------------------------------");
		System.out.println("Add the serial Number that you want to search in the Database: ");
		String serialNumber = scanner.next();
		for (Vehicle vehicle : SingletonVehiclesFleet.getSingleInstance().getListOfVehicle()) {
			if (vehicle.getSerialNumber().compareTo(serialNumber) == 0) {
				if (vehicle.getType() == VehicleType.ElectricVehicle) {
					try {
						SingletonDBConnection.GetInstance().searchElectricVehicle(serialNumber);
						System.out.println(vehicle);

						// Deleting the searched vehicle from DB
						System.out.print(
								"Do you want to delete the row that you just searched? [press 1 for yes or 0 for no]");
						int delete = scanner.nextInt();
						switch (delete) {
						case 1:
							System.out.println("\n------------------------------------------------------");
							System.out.println("Database Deleting row");
							try {
								SingletonDBConnection.GetInstance().deleteElectricVehicle(vehicle.getSerialNumber());
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					} catch (NumberFormatException | SQLException | NegativeNumberException | EmptyFieldException e) {
						e.printStackTrace();
					}
				} else if (vehicle.getType() == VehicleType.GasVehicle) {
					try {
						SingletonDBConnection.GetInstance().searchGasVehicle(vehicle.getSerialNumber());
						System.out.println(vehicle);

						// Deleting the searched vehicle from DB
						System.out.print(
								"Do you want to delete the row that you just searched? [press 1 for yes or 0 for no]");
						int delete = scanner.nextInt();
						switch (delete) {
						case 1:
							System.out.println("\n------------------------------------------------------");
							System.out.println("Database Deleting row");
							try {
								SingletonDBConnection.GetInstance().deleteGasVehicle(vehicle.getSerialNumber());

							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					} catch (NumberFormatException | SQLException | NegativeNumberException | EmptyFieldException e) {
						e.printStackTrace();
					}
				}
			}
		}

		// Update from DB
		System.out.println("\n------------------------------------------------------");
		System.out.println("Database updated after search and delete action");
		Random rand = new Random();
		if (vehiclesList.size() > 0) {
			for (Vehicle vehicle : vehiclesList) {
				try {
					vehicle.setTripCounter(rand.nextInt(50) + 1);
				} catch (NegativeNumberException | EmptyFieldException e) {
					e.printStackTrace();
				}

				try {
					SingletonDBConnection.GetInstance().update(vehicle);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		try {
			vehiclesList = SingletonDBConnection.GetInstance().select();
		} catch (NumberFormatException | SQLException | NegativeNumberException | EmptyFieldException e) {
			e.printStackTrace();
		}

		System.out.println("\n------------------------------------------------------");
		System.out.println("All Electric Vehicles from database after all changes");
		System.out.println("\n------------------------------------------------------");

		for (Vehicle ev : vehiclesList) {
			if (ev.getType() == VehicleType.ElectricVehicle) {
				System.out.println(ev.toString());
			}
		}

		System.out.println("\n------------------------------------------------------");
		System.out.println("All Gas Vehicles from database after all changes");
		System.out.println("\n------------------------------------------------------");
		for (Vehicle gv : vehiclesList) {
			if (gv.getType() == VehicleType.GasVehicle) {
				System.out.println(gv.toString());
			}
		}

		// End of application
		System.out.println("\n------------------------------------------------------");
		System.out.println("End of application. Thanks for testing");
		scanner.close();
		System.exit(0);
	}
}

/*
 * What type of counter? [Type 1: Gas Vehicle / Type 2: Electric Vehicle] / [0-
 * to exit] 1 Serial Number? Serial10 Trip Counter? 100 Gas Consumed? 20 Model?
 * 30 Made? 201 Continue? [1-to continue / 0- to exit] 1 What type of counter?
 * [Type 1: Gas Vehicle / Type 2: Electric Vehicle] / [0- to exit] 2 Serial
 * Number? Serial20 Trip Counter? 20 Energy Consumed? 40 Model? 50 Made? 2021
 * Continue? [1-to continue / 0- to exit] 0
 * 
 * ------------------------------------------------------ End of Vehicles
 * creation
 * 
 * ------------------------------------------------------ Search a Vehicle by
 * its serial number: Serial10 GasVehicle{, tripCounter=100,
 * energyConsumed=20.0, serialNumber='Serial10', model=30, made='201',
 * type=GasVehicle}
 * 
 * ------------------------------------------------------ Printing only Gas
 * vehicles, before sorting: GasVehicle{, tripCounter=100, energyConsumed=20.0,
 * serialNumber='Serial10', model=30, made='201', type=GasVehicle}
 * 
 * ------------------------------------------------------
 * 
 * Printing only Electric vehicles, before sorting: ElectricVehicle{,
 * tripCounter=20, energyConsumed=40.0, serialNumber='Serial20', model=50,
 * made='2021', type=ElectricVehicle}
 * 
 * ------------------------------------------------------ Printing the entire
 * fleet of vehicles, before sorting: GasVehicle{, tripCounter=100,
 * energyConsumed=20.0, serialNumber='Serial10', model=30, made='201',
 * type=GasVehicle} ElectricVehicle{, tripCounter=20, energyConsumed=40.0,
 * serialNumber='Serial20', model=50, made='2021', type=ElectricVehicle}
 * 
 * ------------------------------------------------------ Printing vehicles,
 * after sorting by Mileage Efficiency (Decreasing): GasVehicle{,
 * tripCounter=100, energyConsumed=20.0, serialNumber='Serial10', model=30,
 * made='201', type=GasVehicle} ElectricVehicle{, tripCounter=20,
 * energyConsumed=40.0, serialNumber='Serial20', model=50, made='2021',
 * type=ElectricVehicle}
 * 
 * ------------------------------------------------------ Printing vehicles,
 * after sorting by Serial Number and depending on its type (Increasing):
 * ElectricVehicle{, tripCounter=20, energyConsumed=40.0,
 * serialNumber='Serial20', model=50, made='2021', type=ElectricVehicle}
 * GasVehicle{, tripCounter=100, energyConsumed=20.0, serialNumber='Serial10',
 * model=30, made='201', type=GasVehicle}
 * 
 * ------------------------------------------------------ Serializing final
 * vehicle list...
 * 
 * LIST of vehicles FROM SERIALIZED FILE ElectricVehicle{, tripCounter=20,
 * energyConsumed=40.0, serialNumber='Serial20', model=50, made='2021',
 * type=ElectricVehicle} GasVehicle{, tripCounter=100, energyConsumed=20.0,
 * serialNumber='Serial10', model=30, made='201', type=GasVehicle}
 * 
 * ------------------------------------------------------ Database Inserting row
 * Connection successful Connection successful
 * 
 * ------------------------------------------------------ Database Selecting all
 * rows from ElectricVehicle and GasVehicle Connection successful Connection
 * successful
 * 
 * All Vehicles in the Database ElectricVehicle{, tripCounter=3,
 * energyConsumed=10.5, serialNumber='Chevy1', model=10, made='Chevy',
 * type=ElectricVehicle} ElectricVehicle{, tripCounter=22, energyConsumed=10.5,
 * serialNumber='Chevy2', model=10, made='Chevy', type=ElectricVehicle}
 * ElectricVehicle{, tripCounter=20, energyConsumed=40.0,
 * serialNumber='Serial20', model=50, made='2021', type=ElectricVehicle}
 * ElectricVehicle{, tripCounter=3, energyConsumed=20.0, serialNumber='Plop100',
 * model=30, made='40', type=ElectricVehicle} ElectricVehicle{, tripCounter=42,
 * energyConsumed=10.0, serialNumber='Mazda1', model=10, made='10',
 * type=ElectricVehicle}
 * 
 * ------------------------------------------------------ GasVehicle{,
 * tripCounter=100, energyConsumed=20.0, serialNumber='Serial10', model=30,
 * made='201', type=GasVehicle} GasVehicle{, tripCounter=41,
 * energyConsumed=15.0, serialNumber='Honda2', model=10, made='Honda',
 * type=GasVehicle} GasVehicle{, tripCounter=25, energyConsumed=31.0,
 * serialNumber='10', model=25, made='20', type=GasVehicle} GasVehicle{,
 * tripCounter=29, energyConsumed=20.0, serialNumber='Honda4', model=20,
 * made='20', type=GasVehicle} GasVehicle{, tripCounter=15,
 * energyConsumed=100.0, serialNumber='Mazda1', model=10, made='10',
 * type=GasVehicle} GasVehicle{, tripCounter=8, energyConsumed=10.0,
 * serialNumber='Mazda2', model=10, made='10', type=GasVehicle}
 * 
 * ------------------------------------------------------ Database updated
 * before search and delete action Connection successful Connection successful
 * Connection successful Connection successful Connection successful Connection
 * successful Connection successful Connection successful Connection successful
 * Connection successful Connection successful
 * 
 * ------------------------------------------------------ Add the serial Number
 * that you want to search in the Database: 10 Connection successful
 * GasVehicle{, tripCounter=25, energyConsumed=31.0, serialNumber='10',
 * model=25, made='20', type=GasVehicle} Do you want to delete the row that you
 * just searched? [press 1 for yes or 0 for no]1
 * 
 * ------------------------------------------------------ Database Deleting row
 * Connection successful
 * 
 * ------------------------------------------------------ Database updated after
 * search and delete action Connection successful Connection successful
 * Connection successful Connection successful Connection successful Connection
 * successful Connection successful Connection successful Connection successful
 * Connection successful Connection successful Connection successful Connection
 * successful
 * 
 * ------------------------------------------------------ All Electric Vehicles
 * from database after all changes
 * 
 * ------------------------------------------------------ ElectricVehicle{,
 * tripCounter=47, energyConsumed=10.5, serialNumber='Chevy1', model=10,
 * made='Chevy', type=ElectricVehicle} ElectricVehicle{, tripCounter=11,
 * energyConsumed=10.5, serialNumber='Chevy2', model=10, made='Chevy',
 * type=ElectricVehicle} ElectricVehicle{, tripCounter=35, energyConsumed=40.0,
 * serialNumber='Serial20', model=50, made='2021', type=ElectricVehicle}
 * ElectricVehicle{, tripCounter=45, energyConsumed=20.0,
 * serialNumber='Plop100', model=30, made='40', type=ElectricVehicle}
 * ElectricVehicle{, tripCounter=41, energyConsumed=10.0, serialNumber='Mazda1',
 * model=10, made='10', type=ElectricVehicle}
 * 
 * ------------------------------------------------------ All Gas Vehicles from
 * database after all changes
 * 
 * ------------------------------------------------------ GasVehicle{,
 * tripCounter=18, energyConsumed=20.0, serialNumber='Serial10', model=30,
 * made='201', type=GasVehicle} GasVehicle{, tripCounter=29,
 * energyConsumed=15.0, serialNumber='Honda2', model=10, made='Honda',
 * type=GasVehicle} GasVehicle{, tripCounter=19, energyConsumed=20.0,
 * serialNumber='Honda4', model=20, made='20', type=GasVehicle} GasVehicle{,
 * tripCounter=6, energyConsumed=100.0, serialNumber='Mazda1', model=10,
 * made='10', type=GasVehicle} GasVehicle{, tripCounter=47, energyConsumed=10.0,
 * serialNumber='Mazda2', model=10, made='10', type=GasVehicle}
 * 
 * ------------------------------------------------------ End of application.
 * Thanks for testing
 */