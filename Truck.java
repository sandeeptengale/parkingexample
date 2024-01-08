public class Truck extends Vehicle {
    public Truck(String vehicleNumber) {
        payment = new TruckPayment();
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getType() {
        return VehicleType.TRUCK;
    }
}
