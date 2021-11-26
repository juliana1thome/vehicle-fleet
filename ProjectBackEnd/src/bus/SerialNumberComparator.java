package bus;

import java.util.Comparator;

public class SerialNumberComparator implements Comparator<Vehicle> {

	@Override
	public int compare(Vehicle vehicle1, Vehicle vehicle2) {
		// TODO Auto-generated method stub
		if (vehicle1.getSerialNumber().compareTo(vehicle2.getSerialNumber()) < 0) {
			return 1;
		} else if (vehicle1.getSerialNumber().compareTo(vehicle2.getSerialNumber()) > 0) {
			return -1;
		}
		return 0;
	}

}