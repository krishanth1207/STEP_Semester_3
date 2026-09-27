package session_8.assigment_problems;

import java.util.Scanner;

abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract String getType();
    public abstract double calculateBill();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public String getType() {
        return "SINGLE";
    }

    @Override
    public double calculateBill() {
        return units * 8.0;
    }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public String getType() {
        return "SHARED";
    }

    @Override
    public double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class ACRoom extends Room {
    public ACRoom(int units) {
        super(units);
    }

    @Override
    public String getType() {
        return "AC";
    }

    @Override
    public double calculateBill() {
        return (units * 10.0) + 200.0;
    }
}

public class ElectricityBill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();

        Room[] rooms = new Room[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();

            if (type.equalsIgnoreCase("SINGLE")) {
                rooms[i] = new SingleRoom(units);
            } else if (type.equalsIgnoreCase("SHARED")) {
                int occupants = scanner.nextInt();
                rooms[i] = new SharedRoom(units, occupants);
            } else if (type.equalsIgnoreCase("AC")) {
                rooms[i] = new ACRoom(units);
            }
        }

        double grandTotal = 0.0;
        for (int i = 0; i < n; i++) {
            double bill = rooms[i].calculateBill();
            grandTotal += bill;
            System.out.printf("%s: %.2f\n", rooms[i].getType(), bill);
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}
