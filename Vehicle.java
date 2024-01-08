public class Vehicle {
    protected String vehicleNumber;
    protected Payment payment;
    protected long parkTime;

    public VehicleType getType() {
        return null;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public long getParkTime() {
        return parkTime;
    }

    public void setParkTime() {
        this.parkTime = System.currentTimeMillis();
    }

    public double calculateCost(double hours) {
        return payment.calculateCost(hours);
    }
}
