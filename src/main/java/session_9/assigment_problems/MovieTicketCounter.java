package session_9.assigment_problems;

import java.util.Scanner;

abstract class Ticket {
    protected int count;
    protected static final double CONVENIENCE_FEE = 20.0;

    public Ticket(int count) {
        this.count = count;
    }

    public abstract String getSeatType();
    public abstract double getBasePricePerTicket();

    public double calculateTotalAmount() {
        return count * (getBasePricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super(count);
    }

    @Override
    public String getSeatType() {
        return "REGULAR";
    }

    @Override
    public double getBasePricePerTicket() {
        return 150.0;
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    public String getSeatType() {
        return "PREMIUM";
    }

    @Override
    public double getBasePricePerTicket() {
        return 250.0;
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    public String getSeatType() {
        return "RECLINER";
    }

    @Override
    public double getBasePricePerTicket() {
        return 400.0;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();

        Ticket[] bookings = new Ticket[n];

        for (int i = 0; i < n; i++) {
            String seat = scanner.next();
            int count = scanner.nextInt();

            if (seat.equalsIgnoreCase("REGULAR")) {
                bookings[i] = new RegularTicket(count);
            } else if (seat.equalsIgnoreCase("PREMIUM")) {
                bookings[i] = new PremiumTicket(count);
            } else if (seat.equalsIgnoreCase("RECLINER")) {
                bookings[i] = new ReclinerTicket(count);
            }
        }

        double grandTotal = 0.0;
        for (int i = 0; i < n; i++) {
            double amount = bookings[i].calculateTotalAmount();
            grandTotal += amount;
            System.out.printf("%s: %.2f\n", bookings[i].getSeatType(), amount);
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}
