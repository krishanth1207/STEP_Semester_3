package session_9.assigment_problems;

import java.util.Scanner;

interface SaverModeSupported {
    double applySaverDiscount(double units);
}

abstract class Appliance {
    protected double hours;

    public Appliance(double hours) {
        this.hours = hours;
    }

    public abstract String getType();
    public abstract double getPowerWatts();

    public double calculateBaseUnits() {
        return (getPowerWatts() * hours) / 1000.0;
    }

    public double calculateCost(double units) {
        return units * 8.0;
    }
}

class FridgeAppliance extends Appliance {
    public FridgeAppliance(double hours) {
        super(hours);
    }

    @Override
    public String getType() {
        return "FRIDGE";
    }

    @Override
    public double getPowerWatts() {
        return 150.0;
    }
}

class ACAppliance extends Appliance implements SaverModeSupported {
    public ACAppliance(double hours) {
        super(hours);
    }

    @Override
    public String getType() {
        return "AC";
    }

    @Override
    public double getPowerWatts() {
        return 1500.0;
    }

    @Override
    public double applySaverDiscount(double units) {
        return units * 0.75;
    }
}

class TVAppliance extends Appliance {
    public TVAppliance(double hours) {
        super(hours);
    }

    @Override
    public String getType() {
        return "TV";
    }

    @Override
    public double getPowerWatts() {
        return 100.0;
    }
}

class WasherAppliance extends Appliance implements SaverModeSupported {
    public WasherAppliance(double hours) {
        super(hours);
    }

    @Override
    public String getType() {
        return "WASHER";
    }

    @Override
    public double getPowerWatts() {
        return 500.0;
    }

    @Override
    public double applySaverDiscount(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = Integer.parseInt(scanner.nextLine().trim());

        double grandTotalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");

            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean isSaver = (parts.length > 2 && parts[2].equalsIgnoreCase("SAVER"));

            Appliance appliance = null;
            if (type.equalsIgnoreCase("FRIDGE")) {
                appliance = new FridgeAppliance(hours);
            } else if (type.equalsIgnoreCase("AC")) {
                appliance = new ACAppliance(hours);
            } else if (type.equalsIgnoreCase("TV")) {
                appliance = new TVAppliance(hours);
            } else if (type.equalsIgnoreCase("WASHER")) {
                appliance = new WasherAppliance(hours);
            }

            if (appliance == null) continue;

            if (isSaver) {
                if (appliance instanceof SaverModeSupported) {
                    double baseUnits = appliance.calculateBaseUnits();
                    double saverUnits = ((SaverModeSupported) appliance).applySaverDiscount(baseUnits);
                    double cost = appliance.calculateCost(saverUnits);
                    grandTotalCost += cost;
                    System.out.printf("%s: Units=%.2f Cost=%.2f\n", appliance.getType(), saverUnits, cost);
                } else {
                    System.out.printf("%s: saver mode not supported\n", appliance.getType());
                }
            } else {
                double baseUnits = appliance.calculateBaseUnits();
                double cost = appliance.calculateCost(baseUnits);
                grandTotalCost += cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f\n", appliance.getType(), baseUnits, cost);
            }
        }

        System.out.printf("Total Cost: %.2f\n", grandTotalCost);
        scanner.close();
    }
}
