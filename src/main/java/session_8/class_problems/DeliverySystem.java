package session_8.class_problems;

import java.util.Scanner;

abstract class Delivery {
    protected double weight;
    protected double distance;

    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract String getType();
    public abstract double calculateFee();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public String getType() {
        return "STANDARD";
    }

    @Override
    public double calculateFee() {
        return 5.0 + (weight * 0.50) + (distance * 0.10);
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public String getType() {
        return "EXPRESS";
    }

    @Override
    public double calculateFee() {
        return 15.0 + (weight * 1.00) + (distance * 0.20);
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public String getType() {
        return "INTERNATIONAL";
    }

    @Override
    public double calculateFee() {
        return 25.0 + (weight * 2.00) + (distance * 0.50) + customsFee;
    }
}

public class DeliverySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        Delivery[] deliveries = new Delivery[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();

            if (type.equalsIgnoreCase("STANDARD")) {
                deliveries[i] = new StandardDelivery(weight, distance);
            } else if (type.equalsIgnoreCase("EXPRESS")) {
                deliveries[i] = new ExpressDelivery(weight, distance);
            } else if (type.equalsIgnoreCase("INTERNATIONAL")) {
                double customsFee = scanner.nextDouble();
                deliveries[i] = new InternationalDelivery(weight, distance, customsFee);
            }
        }

        double grandTotal = 0.0;
        for (int i = 0; i < n; i++) {
            double fee = deliveries[i].calculateFee();
            grandTotal += fee;
            System.out.printf("%s: %.2f\n", deliveries[i].getType(), fee);
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}
