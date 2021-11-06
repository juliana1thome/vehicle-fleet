package bus;

import java.util.Comparator;

public class MileageEfficiencyComparator implements Comparator<Vehicle> {

	@Override
	public int compare(Vehicle vehicle1, Vehicle vehicle2) {
		// TODO Auto-generated method stub
		if (vehicle1.getMilePerUnitOfEnergy().compareTo(vehicle2.getMilePerUnitOfEnergy()) < 0) {
			return 1;
		} else if (vehicle1.getMilePerUnitOfEnergy().compareTo(vehicle2.getMilePerUnitOfEnergy()) > 0) {
			return -1;
		}
		return 0;
	}

}
