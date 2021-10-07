package bus;

public class ElectricVehicle extends Vehicle {

	// Variables:
	Double kwPowerConsumed;

	// Constructor:
	public ElectricVehicle(Integer tripCounter, Double energyConsumed, String serialNumber, Short model, String made) {
		super(tripCounter, energyConsumed, serialNumber, model, made);
		this.kwPowerConsumed = energyConsumed;
	}

	// Default Constructor:
	public ElectricVehicle() {
		super();
		this.kwPowerConsumed = null;
	}

	// Getters and Setters:
	public Double getFuelConsumed() {
		return kwPowerConsumed;
	}

	public void setFuelConsumed(Double energyConsumed) {
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
	public double getMilePerUnitOfEnergy() {
		return tripCounter / kwPowerConsumed;
	}

	@Override
	public void makeTrip(int tripCounter, double kwPowerConsumed) {
	}
}
