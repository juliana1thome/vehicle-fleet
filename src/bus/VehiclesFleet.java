package bus;

import java.util.ArrayList;
import java.util.Collections;

public class VehiclesFleet {

	// Creating an array list to save all my Vehicles
	private static ArrayList<Vehicle> vehicleArrayList = new ArrayList<Vehicle>();

	// Public functions
	public static void add(Vehicle object) {
		vehicleArrayList.add(object);
	}
	// public static void add(Vehicle newVehicle){vehicleArrayList.add(newVehicle);}

	public static void remove(Vehicle object) {
		vehicleArrayList.remove(object);
	}
	// public void remove(Vehicle newVehicle){vehicleArrayList.remove(newVehicle);}

	public static ArrayList<Vehicle> getListOfVehicle() {
		return vehicleArrayList;
	}

	// Jin: This is not need I think
	public static void setListOfVehicle(ArrayList<Vehicle> vehicleArrayList) {
		VehiclesFleet.vehicleArrayList = vehicleArrayList;
	}

	public static void print(VehicleType type) {
		for (Vehicle vehicle : vehicleArrayList) {
			if (vehicle.getType() == type) {
				printVehicle(vehicle);
			}
		}
	}

	public static void print() {
		for (Vehicle vehicle : vehicleArrayList) {
			printVehicle(vehicle);
		}
	}

	private static void printVehicle(Vehicle vehicle) {
		if (vehicle.getClass() == GasVehicle.class) {
			System.out.println(((GasVehicle) vehicle).toString());
		} else if (vehicle.getClass() == ElectricVehicle.class) {
			System.out.println(((ElectricVehicle) vehicle).toString());
		} else {
			System.out.println(vehicle.toString());
		}
	}

	public static void sortBySerialNumber() {
		Collections.sort(vehicleArrayList, new SerialNumberComparator());
	}

	public static void sortByMileageEfficiency() {
		Collections.sort(vehicleArrayList, new MileageEfficiencyComparator());
	}
}
