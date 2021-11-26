package bus;

public class GasVehicle extends Vehicle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Double fuelConsumed;

	// Constructor:
	public GasVehicle(Integer tripCounter, Double energyConsumed, String serialNumber, Short model, String made) throws NegativeNumberException, EmptyFieldException {
		super(tripCounter, energyConsumed, serialNumber, model, made);
		this.type = VehicleType.GasVehicle;
//		this.fuelConsumed = energyConsumed;
		this.setEnergyConsumed(energyConsumed);
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

	public void setEnergyConsumed(Double fuelConsumed) throws EmptyFieldException, NegativeNumberException {
		Validator.validateValueEmpty(String.valueOf(fuelConsumed));
		Validator.validateNegativeNumber(fuelConsumed);
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
