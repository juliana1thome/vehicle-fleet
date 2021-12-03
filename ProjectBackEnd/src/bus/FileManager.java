package bus;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class FileManager {
	// Encapsulation
	/////////////////
	private static String filePath = "src//data//vehiclefleet.ser";
	// depending on where your project is this file path will change. So, please try
	// this: src//data//vehiclefleet.ser

	public static void writeSerializedFile(ArrayList<Vehicle> vehicleArrayList) throws IOException {
		// To write (to save) data into the physical file(VehicleFleet.ser)
		FileOutputStream fileOutputStream = new FileOutputStream(filePath);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

		// Write the collection of vehicles (vehiclesList1) into the file
		// (VehicleFleet.ser)
		objectOutputStream.writeObject(vehicleArrayList);
		fileOutputStream.close();
	}

	public static ArrayList<Vehicle> readSerializedFileToArrayList() throws IOException, ClassNotFoundException {
		// To read (to load) data from the physical file(VehicleFleet.ser)
		FileInputStream fileInputStream = new FileInputStream(filePath);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

		// Read data from the file
		@SuppressWarnings("unchecked")
		ArrayList<Vehicle> vehicleArrayList = (ArrayList<Vehicle>) objectInputStream.readObject();// down-casting

		// Don't forget to close it
		fileInputStream.close();

		return vehicleArrayList;
	}

	public static void writeSerializedFile(HashMap<String, Vehicle> collection) throws IOException {
		ArrayList<Vehicle> arrayList = new ArrayList<>(((HashMap<String, Vehicle>) collection).values());

		FileOutputStream fos = new FileOutputStream(filePath);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(arrayList);
		fos.close();
	}

	public static HashMap<String, Vehicle> readSerializedFileToHashMap() throws IOException, ClassNotFoundException {
		HashMap<String, Vehicle> vehiclesHashMap = new HashMap<String, Vehicle>();
		ArrayList<Vehicle> vehicleArrayList = new ArrayList<Vehicle>();

		FileInputStream fis = new FileInputStream(filePath);
		ObjectInputStream ois = new ObjectInputStream(fis);

		vehicleArrayList = (ArrayList<Vehicle>) ois.readObject();

		for (Vehicle aVehicle : vehicleArrayList) {

			vehiclesHashMap.put(aVehicle.getSerialNumber(), aVehicle);
		}
		fis.close();
		return vehiclesHashMap;
	}
}
