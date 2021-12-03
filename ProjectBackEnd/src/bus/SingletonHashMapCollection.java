package bus;

import java.util.ArrayList;
import java.util.HashMap;

public class SingletonHashMapCollection {

	private static SingletonHashMapCollection singleInstance = null;
	// From Java API:
	// The implementation provides constant-time performance for the basic
	// operations (get and put)

	private HashMap<String, Vehicle> listOfVehicles;

	private SingletonHashMapCollection() {
		listOfVehicles = new HashMap<String, Vehicle>();
	}

	public static SingletonHashMapCollection getSingleInstance() {
		if (singleInstance == null) {
			singleInstance = new SingletonHashMapCollection();
		}
		return singleInstance;
	}

	public void setListOfVehicles(HashMap<String, Vehicle> listOfVehicles) {
		this.listOfVehicles = listOfVehicles;
	}

	public HashMap<String, Vehicle> getListOfVehicles() {
		return singleInstance.listOfVehicles;
	}

	public void add(Vehicle newVehicle) {
		singleInstance.listOfVehicles.put(newVehicle.getSerialNumber(), newVehicle);
	}

	public void add(String key, Vehicle newVehicle) {

		singleInstance.listOfVehicles.put(key, newVehicle);
	}

	public void add(ArrayList<Vehicle> vehicles) {

		for (Vehicle aVehicle : vehicles) {

			singleInstance.listOfVehicles.put(aVehicle.getSerialNumber(), aVehicle);
		}
	}

	public void clear() {
		singleInstance.listOfVehicles.clear();
	}

	public void remove(Vehicle newVehicle) {

		singleInstance.listOfVehicles.remove(newVehicle.getSerialNumber());
	}

	// 1st way
	public Vehicle search(String key) {
		Vehicle element = null;
		if (singleInstance.listOfVehicles.containsKey(key)) {

			element = singleInstance.listOfVehicles.get(key);
		}

		return element;
	}

	public ArrayList<Vehicle> search2(String key) {
		ArrayList<Vehicle> vehiclesList = new ArrayList<>();
		if (singleInstance.listOfVehicles.containsKey(key)) {

			vehiclesList.add(singleInstance.listOfVehicles.get(key));
		}

		return vehiclesList;
	}

}
