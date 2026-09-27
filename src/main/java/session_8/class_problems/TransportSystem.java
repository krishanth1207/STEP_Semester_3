package session_8.class_problems;

import java.util.Scanner;

abstract class Transport {
    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    public abstract String getType();
    public abstract double calculateFare();
}

class BusTransport extends Transport {
    public BusTransport(double distance) {
        super(distance);
    }

    @Override
    public String getType() {
        return "BUS";
    }

    @Override
    public double calculateFare() {
        double fare = 2.0 + (distance * 0.10);
        if (fare > 10.0) {
            return 10.0;
        }
        return fare;
    }
}

class TrainTransport extends Transport {
    public TrainTransport(double distance) {
        super(distance);
    }

    @Override
    public String getType() {
        return "TRAIN";
    }

    @Override
    public double calculateFare() {
        return 3.0 + (distance * 0.15);
    }
}

class MetroTransport extends Transport {
    private double peakHourFactor;

    public MetroTransport(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public String getType() {
        return "METRO";
    }

    @Override
    public double calculateFare() {
        return (1.50 + (distance * 0.20)) * peakHourFactor;
    }
}

public class TransportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        Transport[] journeys = new Transport[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();

            if (type.equalsIgnoreCase("BUS")) {
                journeys[i] = new BusTransport(distance);
            } else if (type.equalsIgnoreCase("TRAIN")) {
                journeys[i] = new TrainTransport(distance);
            } else if (type.equalsIgnoreCase("METRO")) {
                double factor = scanner.nextDouble();
                journeys[i] = new MetroTransport(distance, factor);
            }
        }

        double grandTotal = 0.0;
        for (int i = 0; i < n; i++) {
            double fare = journeys[i].calculateFare();
            grandTotal += fare;
            System.out.printf("%s: %.2f\n", journeys[i].getType(), fare);
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}
