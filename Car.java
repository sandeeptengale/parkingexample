public class Car extends Vehicle {
    public Car(String vehicleNumber) {
        payment = new CarPayment();
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getType() {
        return VehicleType.CAR;
    }
}
