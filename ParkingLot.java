import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ParkingLot {

    private Map<Integer, Map<Integer, Map<String, Vehicle>>> floors;
    private int floorNo;
    private int rowNo;
    private int spotPerRow;

    public ParkingLot(int floorNo, int rowNo, int spotPerRow) {
        this.floorNo = floorNo;
        this.rowNo = rowNo;
        this.spotPerRow = spotPerRow;

        this.floors = new HashMap<>();
        for (int i = 0; i < floorNo; i++) {
            floors.put(i, new HashMap<>());
        }
    }

    public boolean park(Vehicle vehicle, int floor, int row) {
        if (floor < 0 && floor > floorNo - 1) {
            System.out.println("Invalid floow number passed in the request");
            return false;
        }

        Map<Integer, Map<String, Vehicle>> floorPlan = floors.get(floor);
        Map<String, Vehicle> rowDetails = floorPlan.get(row);
        if (rowDetails == null) {
            rowDetails = new HashMap<>();
            floors.get(floor).put(row, rowDetails);
            floors.get(floor).get(row).put(vehicle.getVehicleNumber(), vehicle);
            return true;
        }

        if (rowDetails.size() >= spotPerRow) {
            System.out.println("Row is already filled");
            return false;
        } else {
            String vechicleNumber = vehicle.getVehicleNumber();
            floors.get(floor).get(row).put(vechicleNumber, vehicle);
            System.out.println("Vehicle of type: " + vehicle.getType() + " with reg num: " + vehicle.getVehicleNumber() + " is added");
            return true;
        }
    }

    public double calculateParkingHours(Vehicle vehicle) {
        for (int i = 0; i < floorNo; i++) {
            Map<Integer, Map<String, Vehicle>> floorMap = floors.get(i);
            if (floorMap != null) {
                for (int j = 0; j < rowNo; j++) {
                    Map<String, Vehicle> rowMap = floorMap.get(j);
                    if (rowMap != null && rowMap.containsKey(vehicle.getVehicleNumber())) {
                        Vehicle veh = rowMap.get(vehicle.getVehicleNumber());
                        long currTime = System.currentTimeMillis();
                        long parkingTime = veh.getParkTime();
                        long diff = currTime - parkingTime;
                        return TimeUnit.MILLISECONDS.toHours(diff);
                    }
                }
            }
        }

        return 0;
    }

    public boolean leave(Vehicle vehicle) {
         for (int i = 0; i < floorNo; i++) {
            Map<Integer, Map<String, Vehicle>> floorMap = floors.get(i);
            if (floorMap != null) {
                for (int j = 0; j < rowNo; j++) {
                    Map<String, Vehicle> rowMap = floorMap.get(j);
                    if (rowMap != null && rowMap.containsKey(vehicle.getVehicleNumber())) {
                        double hours = calculateParkingHours(vehicle);
                        double cost = vehicle.calculateCost(hours);
                        rowMap.remove(vehicle.getVehicleNumber());
                        System.out.println("Vehicle of type: " + vehicle.getType() + " with reg num: " + vehicle.getVehicleNumber() + " is leaving");
                        return true;
                    }
                }
            }
        }
        System.out.println(vehicle.getType() + " not found.");
        return false;
    }

    public void clear() {
        for (int i = 0; i < floorNo; i++) {
            floors.get(i).clear();
        }
    }

    public int availableSlots(int floor) {
        int count = 0;
        Map<Integer, Map<String, Vehicle>> floorMap = floors.get(floor);
        if (floorMap != null) {
            for (int i = 0; i < rowNo; i++) {
                Map<String, Vehicle> rowMap = floorMap.get(i);
                if (rowMap != null) {
                    count += rowMap.size();
                }
            }
        }
        return count;
    }
}
