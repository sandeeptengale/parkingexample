public class Bike extends Vehicle {
    public Bike(String vehicleNumber) {
        payment = new BikePayment();
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getType() {
        return VehicleType.BIKE;
    }
}
