public class Demo {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(3, 10, 20);
        Car car1 = new Car("KA01AV2344");
        Car car2 = new Car("KA02AV23424");
        Bike bike1 = new Bike("KA03AV6787");
        Truck tr1 = new Truck("KA01AV6756");

        System.out.println("Available spots before on floor 0: " + parkingLot.availableSlots(0));
        car1.setParkTime();
        parkingLot.park(car1, 0, 0);
        System.out.println("Available spots after on floor 0: " + parkingLot.availableSlots(0));

        System.out.println("Available spots before on floor 0: " + parkingLot.availableSlots(0));
        car2.setParkTime();
        parkingLot.park(car2, 0, 0);
        System.out.println("Available spots after on floor 0: " + parkingLot.availableSlots(0));

        System.out.println("Available spots before on floor 1: " + parkingLot.availableSlots(1));
        bike1.setParkTime();
        parkingLot.park(bike1, 1, 0);
        System.out.println("Available spots after on floor 1: " + parkingLot.availableSlots(1));

        System.out.println("Available spots before on floor 2: " + parkingLot.availableSlots(2));
        tr1.setParkTime();
        parkingLot.park(tr1, 2, 9);
        System.out.println("Available spots after on floor 2: " + parkingLot.availableSlots(2));

        parkingLot.leave(car1);
        System.out.println("Available spots after car1 left from floor 0: " + parkingLot.availableSlots(0));
        parkingLot.leave(bike1);
        System.out.println("Available spots after bike1 left from floor 1: " + parkingLot.availableSlots(1));
        parkingLot.clear();
    }
}
