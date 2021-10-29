package bus;

import java.util.ArrayList;
import java.util.Collections;

public class VehiclesFleet {

	// Private Functions:

	// Creating an array list to save all my Vehicles
	private static ArrayList<Vehicle> vehicleArrayList = new ArrayList<Vehicle>();

	// Public Functions:

	// Add a Vehicle from fleet
	public static void add(Vehicle object) {
		vehicleArrayList.add(object);
	}

	// Remove a Vehicle from fleet
	public static void remove(Vehicle object) {
		vehicleArrayList.remove(object);
	}

	// Get Vehicle list
	public static ArrayList<Vehicle> getListOfVehicle() {
		return vehicleArrayList;
	}

	// Set Vehicle list
	public static void setListOfVehicle(ArrayList<Vehicle> vehicleArrayList) {
		VehiclesFleet.vehicleArrayList = vehicleArrayList;
	}

	// Print entire fleet of vehicle
	public static void print() {
		for (Vehicle vehicle : vehicleArrayList) {
			System.out.println(vehicle);
		}
	}

	// Print just Gasoline Vehicles
	public static void printGasVehicles(){
		for (Vehicle vehicle: vehicleArrayList)
		{
			if (vehicle.getClass() == GasVehicle.class)
			{
				System.out.println(vehicle);
			}
		}
	}

	// Print just Electric Vehicles
	public static void printElectricVehicles(){
		for (Vehicle vehicle: vehicleArrayList)
		{
			if (vehicle.getClass() == ElectricVehicle.class)
			{
				System.out.println(vehicle);
			}
		}
	}


	// TODO: Think if this is necessary
	// Print by Vehicle type
	public static void printVehicle(Vehicle vehicle) {
		if (vehicle.getClass() == GasVehicle.class) {
			System.out.println(vehicle);
		} else if (vehicle.getClass() == ElectricVehicle.class) {
			System.out.println(vehicle);
		} else {
			System.out.println(vehicle);
		}
	}

	// Search by Serial Number FIX ELSE
	public static void searchBySerialNumber(String serialNumber) {

		for(Vehicle vehicle : vehicleArrayList) {
			if (vehicle.getSerialNumber().compareTo(serialNumber) == 0) {
				System.out.println(vehicle);
			}
		}
	}

	// Sort by Serial Number
	public static void sortBySerialNumber() {
		Collections.sort(vehicleArrayList, new SerialNumberComparator());
	}

	// Sort by Mileage Efficiency
	public static void sortByMileageEfficiency() {
		Collections.sort(vehicleArrayList, new MileageEfficiencyComparator());
	}
}
