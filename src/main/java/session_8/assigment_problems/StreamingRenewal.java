package session_8.assigment_problems;

import java.time.LocalDate;
import java.util.Scanner;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;

    public SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public abstract LocalDate calculateRenewalDate();
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();

        SubscriptionPlan[] subscribers = new SubscriptionPlan[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            String dateStr = scanner.next();
            LocalDate startDate = LocalDate.parse(dateStr);

            if (type.equalsIgnoreCase("BASIC")) {
                subscribers[i] = new BasicPlan(name, startDate);
            } else if (type.equalsIgnoreCase("STANDARD")) {
                subscribers[i] = new StandardPlan(name, startDate);
            } else if (type.equalsIgnoreCase("PREMIUM")) {
                subscribers[i] = new PremiumPlan(name, startDate);
            }
        }

        for (int i = 0; i < n; i++) {
            LocalDate renewalDate = subscribers[i].calculateRenewalDate();
            System.out.println(subscribers[i].getName() + ": " + renewalDate);
        }

        scanner.close();
    }
}
