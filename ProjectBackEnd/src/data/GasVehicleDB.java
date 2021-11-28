package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bus.EmptyFieldException;
import bus.GasVehicle;
import bus.NegativeNumberException;

public class GasVehicleDB {
	static private Connection myConnection;
	static private String mySQLStatement = null;
	static private String mySQLQuery = null;
	static private Statement myStatemnt = null;
	static private ResultSet myResultSet = null;
	static private GasVehicle aVehicle = null;

	/*
	 * return 1 if added successfully otherwise 0
	 */
	public static int insert(GasVehicle aVehicle) throws SQLException {
		myConnection = ConnectionDB.getConnection();
		mySQLStatement = "Insert into GasVehicle(tripcounter, energyconsumed, serialnumber, model, made)  values( "
				+ aVehicle.getTripCounter() + ", " + aVehicle.getEnergyConsumed() + "," + "\'"
				+ aVehicle.getSerialNumber() + "\' , " + aVehicle.getModel() + ", " + aVehicle.getMade() + ")";

		try {
			myStatemnt = myConnection.createStatement();
			int rowAffected = myStatemnt.executeUpdate(mySQLStatement);
			myConnection.commit();
			if (rowAffected > 0) {
				return 1;
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int update(GasVehicle aVehicle) throws SQLException {

		myConnection = ConnectionDB.getConnection();

		mySQLStatement = "update GasVehicle set TripCounter =  \'" + aVehicle.getTripCounter()
				+ "\' WHERE  SerialNumber = " + aVehicle.getSerialNumber();

		try {

			myStatemnt = myConnection.createStatement();

			int rowAffected = myStatemnt.executeUpdate(mySQLStatement);

			myConnection.commit();

			if (rowAffected > 0) {
				return 1;
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 
	 * @param id primary key of vehicle
	 * @return return 1 if removed successfully otherwise 0
	 * @throws SQLException
	 */
	public static int delete(String serialNumber) throws SQLException {
		myConnection = ConnectionDB.getConnection();

		mySQLStatement = "Delete FROM GasVehicle WHERE SerialNumber = \'" + serialNumber + "\'";

		try {
			myStatemnt = myConnection.createStatement();
			int rowAffected = myStatemnt.executeUpdate(mySQLStatement);

			myConnection.commit();

			if (rowAffected > 0) {
				return 1;
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static GasVehicle search(String serialNumber)
			throws SQLException, SQLException, NumberFormatException, NegativeNumberException, EmptyFieldException {

		myConnection = ConnectionDB.getConnection();

		mySQLQuery = "SELECT TripCounter, EnergyConsumed, SerialNumber, Model, Made FROM GasVehicle WHERE  SerialNumber = "
				+ "\'" +serialNumber + "\'";

		myStatemnt = myConnection.createStatement();
		myResultSet = myStatemnt.executeQuery(mySQLQuery);

//		GasVehicle(Integer tripCounter, Double energyConsumed, String serialNumber, Short model, String made) 
		if (myResultSet.next()) {
			aVehicle = new GasVehicle(Integer.parseInt(myResultSet.getString(1)),
					Double.parseDouble(myResultSet.getString(2)), myResultSet.getString(3),
					Short.parseShort(myResultSet.getString(4)), myResultSet.getString(5));
		}
		return aVehicle;
	}

	public static ArrayList<GasVehicle> select()
			throws SQLException, NumberFormatException, SQLException, NegativeNumberException, EmptyFieldException {

		myConnection = ConnectionDB.getConnection();

		mySQLQuery = "SELECT * FROM GasVehicle";

		myStatemnt = myConnection.createStatement();
		myResultSet = myStatemnt.executeQuery(mySQLQuery);

		ArrayList<GasVehicle> myList = new ArrayList<GasVehicle>();
		while (myResultSet.next()) {
			aVehicle = new GasVehicle(Integer.parseInt(myResultSet.getString(1)),
					Double.parseDouble(myResultSet.getString(2)), myResultSet.getString(3),
					Short.parseShort(myResultSet.getString(4)), myResultSet.getString(5));

			myList.add(aVehicle);
		}

		return myList;
	}

}
