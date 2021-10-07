package bus;

import java.util.ArrayList;

public class DataCollection {

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

	public static void setListOfVehicle(ArrayList<Vehicle> vehicleArrayList) {
		DataCollection.vehicleArrayList = vehicleArrayList;
	}
}
