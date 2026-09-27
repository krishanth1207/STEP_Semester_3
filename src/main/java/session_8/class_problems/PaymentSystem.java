package session_8.class_problems;

import java.util.Scanner;

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract String getType();
    public abstract double calculateAdjustedAmount();
}

class CardPayment extends Payment {
    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "CARD";
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.02;
    }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "WALLET";
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.01;
    }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "BANKTRANSFER";
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount;
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        Payment[] payments = new Payment[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();

            if (type.equalsIgnoreCase("CARD")) {
                payments[i] = new CardPayment(amount);
            } else if (type.equalsIgnoreCase("WALLET")) {
                payments[i] = new WalletPayment(amount);
            } else if (type.equalsIgnoreCase("BANKTRANSFER")) {
                payments[i] = new BankTransferPayment(amount);
            }
        }

        double grandTotal = 0.0;
        for (int i = 0; i < n; i++) {
            double adjusted = payments[i].calculateAdjustedAmount();
            grandTotal += adjusted;
            System.out.printf("%s: %.2f\n", payments[i].getType(), adjusted);
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}
