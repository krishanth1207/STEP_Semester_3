package session_8.assigment_problems;

import java.util.Scanner;

abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract String getType();
    public abstract double calculateCharge();
}

class BikeVehicle extends Vehicle {
    public BikeVehicle(int hours) {
        super(hours);
    }

    @Override
    public String getType() {
        return "BIKE";
    }

    @Override
    public double calculateCharge() {
        return hours * 10.0;
    }
}

class CarVehicle extends Vehicle {
    public CarVehicle(int hours) {
        super(hours);
    }

    @Override
    public String getType() {
        return "CAR";
    }

    @Override
    public double calculateCharge() {
        return 30.0 + ((hours - 1) * 20.0);
    }
}

class TruckVehicle extends Vehicle {
    public TruckVehicle(int hours) {
        super(hours);
    }

    @Override
    public String getType() {
        return "TRUCK";
    }

    @Override
    public double calculateCharge() {
        double charge = hours * 50.0;
        if (charge < 100.0) {
            return 100.0;
        }
        return charge;
    }
}

public class ParkingCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();

        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();

            if (type.equalsIgnoreCase("BIKE")) {
                vehicles[i] = new BikeVehicle(hours);
            } else if (type.equalsIgnoreCase("CAR")) {
                vehicles[i] = new CarVehicle(hours);
            } else if (type.equalsIgnoreCase("TRUCK")) {
                vehicles[i] = new TruckVehicle(hours);
            }
        }

        double grandTotal = 0.0;
        for (int i = 0; i < n; i++) {
            double charge = vehicles[i].calculateCharge();
            grandTotal += charge;
            System.out.printf("%s: %.2f\n", vehicles[i].getType(), charge);
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}
