package bus;

public class ElectricVehicle extends Vehicle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Variables:
	Double kwPowerConsumed;

	// Constructor:
	public ElectricVehicle(Integer tripCounter, Double energyConsumed, String serialNumber, Short model, String made) throws NegativeNumberException, EmptyFieldException {
		super(tripCounter, energyConsumed, serialNumber, model, made);
		this.type = VehicleType.ElectricVehicle;
//		this.kwPowerConsumed = energyConsumed;
		this.setEnergyConsumed(energyConsumed);
	}

	// Default Constructor:
	public ElectricVehicle() {
		super();
		this.kwPowerConsumed = null;
	}

	// Getters and Setters:
	public Double getEnergyConsumed() {
		return kwPowerConsumed;
	}

	public void setEnergyConsumed(Double kwPowerConsumed) throws NegativeNumberException, EmptyFieldException {
		Validator.validateValueEmpty(String.valueOf(kwPowerConsumed));
		Validator.validateNegativeNumber(kwPowerConsumed);
		this.kwPowerConsumed = kwPowerConsumed;
	}

	// ToString:

	@Override
	public String toString() {
		return "ElectricVehicle{" + ", tripCounter=" + tripCounter + ", energyConsumed=" + kwPowerConsumed
				+ ", serialNumber='" + serialNumber + '\'' + ", model=" + model + ", made='" + made + '\'' + ", type="
				+ type + '}';
	}

	// Functions:
	@Override
	public Double getMilePerUnitOfEnergy() {
		return tripCounter / kwPowerConsumed;
	}

	@Override
	public void makeTrip(Integer tripCounter, Double kwPowerConsumed) {
		this.tripCounter = tripCounter;
		this.kwPowerConsumed = kwPowerConsumed;

	}
}
