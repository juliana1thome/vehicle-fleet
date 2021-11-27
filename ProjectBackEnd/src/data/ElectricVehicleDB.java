package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bus.ElectricVehicle;
import bus.EmptyFieldException;
import bus.NegativeNumberException;

public class ElectricVehicleDB {
	static private Connection myConnection;
	static private String mySQLStatement = null;
	static private String mySQLQuery = null;
	static private Statement myStatemnt = null;
	static private ResultSet myResultSet = null;
	static private ElectricVehicle aVehicle = null;

	/*
	 * return 1 if added successfully otherwise 0
	 */
	public static int insert(ElectricVehicle aVehicle) throws SQLException {
		myConnection = ConnectionDB.getConnection();
		mySQLStatement = "Insert into ElectricVehicle(tripcounter, kwpowerconsumed, serialnumber, model, made)  values( "
				+ aVehicle.getTripCounter() + ", " + aVehicle.getEnergyConsumed() + ", " + "\'"
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

	public static int update(ElectricVehicle aVehicle) throws SQLException {

		myConnection = ConnectionDB.getConnection();

		mySQLStatement = "update electricvehicle set tripcounter =  " + aVehicle.getTripCounter()
				+ " WHERE  serialnumber = " + "\'" + aVehicle.getSerialNumber() + "\'";

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

		mySQLStatement = "Delete FROM electricvehicle WHERE serialnumber = \'" + serialNumber + "\'";

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

	public static ElectricVehicle search(String serialNumber)
			throws SQLException, SQLException, NumberFormatException, NegativeNumberException, EmptyFieldException {

		myConnection = ConnectionDB.getConnection();

		mySQLQuery = "SELECT tripcounter, kwpowerconsumed, serialnumber, model, made FROM ElectricVehicle WHERE  SerialNumber = \'"
				+ serialNumber + "\'";

		myStatemnt = myConnection.createStatement();

		myResultSet = myStatemnt.executeQuery(mySQLQuery);

		// ElectricVehicle(Integer tripCounter, Double energyConsumed, String
		// serialNumber, Short model, String made)
		if (myResultSet.next()) {
			aVehicle = new ElectricVehicle(Integer.parseInt(myResultSet.getString(1)),
					Double.parseDouble(myResultSet.getString(2)), myResultSet.getString(3),
					Short.parseShort(myResultSet.getString(4)), myResultSet.getString(5));
		}
		return aVehicle;
	}

	public static ArrayList<ElectricVehicle> select()
			throws SQLException, NumberFormatException, SQLException, NegativeNumberException, EmptyFieldException {

		myConnection = ConnectionDB.getConnection();

		mySQLQuery = "SELECT * FROM electricvehicle";

		myStatemnt = myConnection.createStatement();
		myResultSet = myStatemnt.executeQuery(mySQLQuery);

		ArrayList<ElectricVehicle> myList = new ArrayList<ElectricVehicle>();
		while (myResultSet.next()) {
			aVehicle = new ElectricVehicle(Integer.parseInt(myResultSet.getString(1)),
					Double.parseDouble(myResultSet.getString(2)), myResultSet.getString(3),
					Short.parseShort(myResultSet.getString(4)), myResultSet.getString(5));
			myList.add(aVehicle);
		}

		return myList;
	}

}
