package session_9.class_problems;

import java.util.Scanner;

abstract class Staff {
    protected String name;

    public Staff(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            double regularPay = 40 * rate;
            double overtimePay = (hours - 40) * rate * 1.5;
            return regularPay + overtimePay;
        }
    }
}

class InternStaff extends Staff {
    private double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();

        Staff[] staffMembers = new Staff[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();

            if (type.equalsIgnoreCase("FULLTIME")) {
                double salary = scanner.nextDouble();
                staffMembers[i] = new FullTimeStaff(name, salary);
            } else if (type.equalsIgnoreCase("HOURLY")) {
                double hours = scanner.nextDouble();
                double rate = scanner.nextDouble();
                staffMembers[i] = new HourlyStaff(name, hours, rate);
            } else if (type.equalsIgnoreCase("INTERN")) {
                double stipend = scanner.nextDouble();
                staffMembers[i] = new InternStaff(name, stipend);
            }
        }

        double totalPayroll = 0.0;
        for (int i = 0; i < n; i++) {
            double pay = staffMembers[i].calculatePay();
            totalPayroll += pay;
            System.out.printf("%s: %.2f\n", staffMembers[i].getName(), pay);
        }

        System.out.printf("Total Payroll: %.2f\n", totalPayroll);
        scanner.close();
    }
}
