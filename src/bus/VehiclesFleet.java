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
				System.out.print(vehicle);
			}
		}
	}

	public static void print() {
		for (Vehicle vehicle : vehicleArrayList) {
			System.out.println(vehicle);
		}
	}

	public static void sortBySerialNumber() {
		Collections.sort(vehicleArrayList, new SerialNumberComparator());
	}

	public static void sortByMileageEfficiency() {
		Collections.sort(vehicleArrayList, new MileageEfficiencyComparator());
	}
	
	public static Vehicle searchBySerialNumber(String serialNumber) {
		// Linear search. To improve we can apply binary search for later
		for(Vehicle vehicle : vehicleArrayList) {
			if(vehicle.getSerialNumber().compareTo(serialNumber) == 0) {
				return vehicle;
			}
		}
		return null;
	}
}
