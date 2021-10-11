package bus;

public class GasVehicle extends Vehicle {
	Double fuelConsumed;

	// Constructor:
	public GasVehicle(Integer tripCounter, Double energyConsumed, String serialNumber, Short model, String made) {
		super(tripCounter, energyConsumed, serialNumber, model, made);
		this.fuelConsumed = energyConsumed;
	}

	// Default Constructor:
	public GasVehicle() {
		super();
		this.fuelConsumed = null;
	}

	// Getters and Setters
	public Double getFuelConsumed() {
		return fuelConsumed;
	}

	public void setFuelConsumed(Double fuelConsumed) {
		this.fuelConsumed = fuelConsumed;
	}

	@Override
	public String toString() {
		return "GasVehicle{" + ", tripCounter=" + tripCounter + ", energyConsumed=" + fuelConsumed + ", serialNumber='"
				+ serialNumber + '\'' + ", model=" + model + ", made='" + made + '\'' + ", type=" + type + '}';
	}

	// Functions
	@Override
	public double getMilePerUnitOfEnergy() {
		return tripCounter / fuelConsumed;
	}

	@Override
	public void makeTrip(int tripCounter, double fuelConsumed) {
		this.tripCounter = tripCounter;
		this.fuelConsumed = fuelConsumed;
	}

	@Override
	public void makeTrip() {
		makeTrip(100, 7.7); 
	}
}
