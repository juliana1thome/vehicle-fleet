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
	public Double getEnergyConsumed() {
		return fuelConsumed;
	}

	public void setEnergyConsumed(Double fuelConsumed) {
		this.fuelConsumed = fuelConsumed;

	}

	@Override
	public String toString() {
		return "GasVehicle{" + ", tripCounter=" + tripCounter + ", energyConsumed=" + fuelConsumed + ", serialNumber='"
				+ serialNumber + '\'' + ", model=" + model + ", made='" + made + '\'' + ", type=" + type + '}';
	}

	// Functions
	@Override
	public Double getMilePerUnitOfEnergy() {
		return tripCounter / fuelConsumed;
	}

	@Override
	public void makeTrip(Integer tripCounter, Double fuelConsumed) {
		this.tripCounter = tripCounter;
		this.fuelConsumed = fuelConsumed;
	}
}
