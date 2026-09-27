package session_8.assigment_problems;

import java.util.Scanner;

abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract String getType();
    public abstract double calculateFinalAmount();
}

class StudentCustomer extends Customer {
    public StudentCustomer(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "STUDENT";
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.90;
    }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "STAFF";
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.95;
    }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "GUEST";
    }

    @Override
    public double calculateFinalAmount() {
        return amount + 10.0;
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();

        Customer[] customers = new Customer[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();

            if (type.equalsIgnoreCase("STUDENT")) {
                customers[i] = new StudentCustomer(amount);
            } else if (type.equalsIgnoreCase("STAFF")) {
                customers[i] = new StaffCustomer(amount);
            } else if (type.equalsIgnoreCase("GUEST")) {
                customers[i] = new GuestCustomer(amount);
            }
        }

        double grandTotal = 0.0;
        for (int i = 0; i < n; i++) {
            double finalAmount = customers[i].calculateFinalAmount();
            grandTotal += finalAmount;
            System.out.printf("%s: %.2f\n", customers[i].getType(), finalAmount);
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}
