package bus;

public class Vehicle implements IMileageEfficiency{

    // TODO: Fix the energyConsumed, and check how to show the getMilePerUnitOfEnergy, and how to do it
    // Item: ElectricVehicle{, tripCounter=1, energyConsumed=null, serialNumber='1', model=1, made='1', type=ElectricVehicle}
    // Item: GasVehicle{, tripCounter=2, energyConsumed=null, serialNumber='2', model=2, made='2', type=GasVehicle}

    // Variables:
    protected Integer tripCounter;
    protected Double energyConsumed;
    protected String serialNumber;
    protected Short model;
    protected String made;
    protected EnumType type;


    // Constructor:
    public Vehicle(Integer tripCounter, Double energyConsumed, String serialNumber, Short model, String made) {
        this.tripCounter = tripCounter;
        this.energyConsumed = energyConsumed;
        this.serialNumber = serialNumber;
        this.model = model;
        this.made = made;
    }

    // Default Constructor:
    public Vehicle() {
        super();
        this.serialNumber = "Undefined";
        this.model = null;
        this.made = "Undefined";
        this.tripCounter = null;
        this.energyConsumed = null;
    }

    // Getters and Setters:

    // Get and Set: Trip Counter
    public Integer getTripCounter() {return tripCounter;}
    public void setTripCounter(Integer tripCounter) {this.tripCounter = tripCounter;}

    // Get and Set: Energy Consumed
    public Double getEnergyConsumed() {return energyConsumed;}
    public void setEnergyConsumed(Double energyConsumed) {this.energyConsumed = energyConsumed;}

    // Get and Set: Serial Number
    public String getSerialNumber() {return serialNumber;}
    public void setSerialNumber(String serialNumber) {this.serialNumber = serialNumber;}

    // Get and Set: Model
    public Short getModel() {return model;}
    public void setModel(Short model) {this.model = model;}

    // Get and Set: Made
    public String getMade() {return made;}
    public void setMade(String made) {this.made = made;}

    // Get and Set: type
    public EnumType getType() {return type;}
    public void setType(EnumType type) {this.type = type;}

    // ToString:
    @Override
    public String toString() {
        return "Vehicle{" +
                "tripCounter=" + tripCounter +
                ", energyConsumed=" + energyConsumed +
                ", serialNumber='" + serialNumber + '\'' +
                ", model=" + model +
                ", made='" + made + '\'' +
                ", type=" + type +
                '}';
    }

    // Functions:

    // Get Mile Per Unit of Energy:
    @Override
    public double getMilePerUnitOfEnergy() {
        return 0;
    }

    // Make Trip:
    public void makeTrip() {}
    public void makeTrip(int tripCounter, double energyConsumed) {}

}
