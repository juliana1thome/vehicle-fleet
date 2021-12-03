package bus;

import java.sql.SQLException;
import java.util.ArrayList;

import data.ElectricVehicleDB;
import data.GasVehicleDB;

public class SingletonDBConnection {
	private static SingletonDBConnection instance = null;

	private SingletonDBConnection() {
	}

	public static SingletonDBConnection GetInstance() {
		if (instance == null) {
			instance = new SingletonDBConnection();
		}
		return instance;
	}

	/**
	 * Function to insert a vehicle element to the database.  
	 * @param vehicle
	 * @throws SQLException
	 */
	public void insert(Vehicle vehicle) throws SQLException {
		if (vehicle.getType() == VehicleType.ElectricVehicle) {
			ElectricVehicleDB.insert((ElectricVehicle) vehicle);
		} else {
			GasVehicleDB.insert((GasVehicle) vehicle);
		}
	}

	
	/**
	 * Function to update a vehicle data.
	 * @param vehicle
	 * @throws SQLException
	 */
	public void update(Vehicle vehicle) throws SQLException {
		if (vehicle.getType() == VehicleType.ElectricVehicle) {
			ElectricVehicleDB.update((ElectricVehicle) vehicle);
		} else {
			GasVehicleDB.update((GasVehicle) vehicle);
		}
	}

	/**
	 * Function to delete an electric vehicle by locating its serial number.
	 * @param serialNumber
	 * @throws SQLException
	 */
	public void deleteElectricVehicle(String serialNumber) throws SQLException {
		ElectricVehicleDB.delete(serialNumber);
	}

	/** 
	 * Function to delete a gas vehicle by locating its serial number.
	 * @param serialNumber
	 * @throws SQLException
	 */
	public void deleteGasVehicle(String serialNumber) throws SQLException {
		GasVehicleDB.delete(serialNumber);
	}

	/**
	 * Function which returns a vehicle from the electric vehicle table.
	 * @param serialNumber
	 * @return
	 * @throws SQLException
	 * @throws NumberFormatException
	 * @throws NegativeNumberException
	 * @throws EmptyFieldException
	 */
	public Vehicle searchElectricVehicle(String serialNumber)
			throws SQLException, NumberFormatException, NegativeNumberException, EmptyFieldException {
		return ElectricVehicleDB.search(serialNumber);
	}

	/**
	 * Function which returns a vehicle form the gas vehicle table. 
	 * @param serialNumber
	 * @return
	 * @throws SQLException
	 * @throws NumberFormatException
	 * @throws NegativeNumberException
	 * @throws EmptyFieldException
	 */
	public Vehicle searchGasVehicle(String serialNumber)
			throws SQLException, NumberFormatException, NegativeNumberException, EmptyFieldException {
		return GasVehicleDB.search(serialNumber);
	}

	
	/** 
	 * Function which returns the array list of vehicle from electric vehicle and gas vehicle tables.
	 * @return
	 * @throws NumberFormatException
	 * @throws SQLException
	 * @throws NegativeNumberException
	 * @throws EmptyFieldException
	 */
	public ArrayList<Vehicle> select()
			throws NumberFormatException, SQLException, NegativeNumberException, EmptyFieldException {
		ArrayList<Vehicle> vehiclesList = new ArrayList<Vehicle>();
		vehiclesList.addAll(ElectricVehicleDB.select());
		vehiclesList.addAll(GasVehicleDB.select());
		return vehiclesList;
	}
}
