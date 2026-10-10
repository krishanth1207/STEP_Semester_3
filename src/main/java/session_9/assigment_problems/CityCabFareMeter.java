package session_9.assigment_problems;

import java.util.Scanner;

interface NightServiceable {
    double calculateNightFare(double dayFare);
}

abstract class Cab {
    protected double distanceKm;

    public Cab(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public abstract String getType();
    public abstract double getRatePerKm();

    public double calculateDayFare() {
        double fare = distanceKm * getRatePerKm();
        if (fare < 100.0) {
            return 100.0;
        }
        return fare;
    }
}

class MiniCab extends Cab {
    public MiniCab(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public String getType() {
        return "MINI";
    }

    @Override
    public double getRatePerKm() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightServiceable {
    public SedanCab(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public String getType() {
        return "SEDAN";
    }

    @Override
    public double getRatePerKm() {
        return 14.0;
    }

    @Override
    public double calculateNightFare(double dayFare) {
        return dayFare * 1.20;
    }
}

class SUVCab extends Cab implements NightServiceable {
    public SUVCab(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public String getType() {
        return "SUV";
    }

    @Override
    public double getRatePerKm() {
        return 18.0;
    }

    @Override
    public double calculateNightFare(double dayFare) {
        return dayFare * 1.20;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();

        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();

            Cab cab = null;
            if (cabType.equalsIgnoreCase("MINI")) {
                cab = new MiniCab(km);
            } else if (cabType.equalsIgnoreCase("SEDAN")) {
                cab = new SedanCab(km);
            } else if (cabType.equalsIgnoreCase("SUV")) {
                cab = new SUVCab(km);
            }

            if (cab == null) continue;

            if (time.equalsIgnoreCase("NIGHT")) {
                if (cab instanceof NightServiceable) {
                    double dayFare = cab.calculateDayFare();
                    double finalFare = ((NightServiceable) cab).calculateNightFare(dayFare);
                    grandTotal += finalFare;
                    System.out.printf("%s: %.2f\n", cab.getType(), finalFare);
                } else {
                    System.out.printf("%s: night service not available\n", cab.getType());
                }
            } else {
                double fare = cab.calculateDayFare();
                grandTotal += fare;
                System.out.printf("%s: %.2f\n", cab.getType(), fare);
            }
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}
