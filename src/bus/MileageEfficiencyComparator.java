package bus;

import java.util.Comparator;

public class MileageEfficiencyComparator implements Comparator<Vehicle> {

	@Override
	public int compare(Vehicle o1, Vehicle o2) {
		// TODO Auto-generated method stub
		if (o1.getEnergyConsumed().compareTo(o2.getEnergyConsumed()) > 0) {
			return 1;
		} else if (o1.getEnergyConsumed().compareTo(o2.getEnergyConsumed()) < 0) {
			return -1;
		}
		return 0;
	}

}
