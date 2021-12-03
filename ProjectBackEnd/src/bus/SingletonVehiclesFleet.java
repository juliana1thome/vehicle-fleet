package bus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class SingletonVehiclesFleet {

	private static SingletonVehiclesFleet singleInstance = null;
	private ArrayList<Vehicle> vehicleArrayList = null;

	// Singleton:
	private SingletonVehiclesFleet() {
		vehicleArrayList = new ArrayList<Vehicle>();
	}

	// Singleton:
	public static SingletonVehiclesFleet getSingleInstance() { // Applying singleton idea
		if (singleInstance == null) {
			singleInstance = new SingletonVehiclesFleet();
		}
		return singleInstance;
	}

	// Singleton:
	private void setSingleInstance(SingletonVehiclesFleet singleInstance) {
		SingletonVehiclesFleet.singleInstance = singleInstance;
	}

	// Public Functions:
	// Setter of Vehicle list;
	public void setListOfVehicle(ArrayList<Vehicle> vehiclesList) {
		vehicleArrayList = vehiclesList;
	}
	
	// Getter of Vehicle list:
	public ArrayList<Vehicle> getListOfVehicle() {
		return vehicleArrayList;
	}
	
	// Add a Vehicle from fleet:
	public void add(Vehicle object) {
		singleInstance.vehicleArrayList.add(object);
	}

	// Remove a Vehicle from fleet:
	public void remove(Vehicle object) {
		singleInstance.vehicleArrayList.remove(object);
	}

	// Print entire fleet of vehicle:
	public void print() {
		for (Vehicle vehicle : singleInstance.vehicleArrayList) {
			System.out.println(vehicle);
		}
	}

	// Print just Gasoline Vehicles:
	public void printGasVehicles() {
		for (Vehicle vehicle : singleInstance.vehicleArrayList) {
			if (vehicle.getClass() == GasVehicle.class) {
				System.out.println(vehicle);
			}
		}
	}

	// Print just Electric Vehicles:
	public void printElectricVehicles() {
		for (Vehicle vehicle : singleInstance.vehicleArrayList) {
			if (vehicle.getClass() == ElectricVehicle.class) {
				System.out.println(vehicle);
			}
		}
	}

	// Search by Serial Number:
	public void searchBySerialNumber(String serialNumber) {

		for (Vehicle vehicle : singleInstance.vehicleArrayList) {
			if (vehicle.getSerialNumber().compareTo(serialNumber) == 0) {
				System.out.println(vehicle);
			}
		}
	}

	// Sort by Serial Number:
	public void sortBySerialNumber() {
		Collections.sort(singleInstance.vehicleArrayList, new SerialNumberComparator());
	}

	// Sort by Mileage Efficiency:
	public void sortByMileageEfficiency() {
		Collections.sort(singleInstance.vehicleArrayList, new MileageEfficiencyComparator());
	}

	// Serialization:
	public void Serialized() throws IOException, ClassNotFoundException {
		FileManager.writeSerializedFile(getListOfVehicle());

		System.out.println("\n LIST of vehicles FROM SERIALIZED FILE");
		for (Vehicle vehicle : FileManager.readSerializedFileToArrayList()) {
			System.out.println(vehicle);
		}
	}
}
