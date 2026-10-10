package session_9.assigment_problems;

import java.util.Scanner;

interface BusUser {
    double getTransportFee();
}

abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateTuition();

    public double calculateTotalFee() {
        double fee = calculateTuition();
        if (this instanceof BusUser) {
            fee += ((BusUser) this).getTransportFee();
        }
        return fee;
    }
}

class DayScholarStudent extends Student implements BusUser {
    public DayScholarStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.0;
    }

    @Override
    public double getTransportFee() {
        return 12000.0;
    }
}

class HostellerStudent extends Student {
    public HostellerStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.0 + 60000.0;
    }
}

class ScholarStudent extends Student implements BusUser {
    public ScholarStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 20000.0;
    }

    @Override
    public double getTransportFee() {
        return 12000.0;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();

            if (type.equalsIgnoreCase("DAY_SCHOLAR")) {
                students[i] = new DayScholarStudent(name);
            } else if (type.equalsIgnoreCase("HOSTELLER")) {
                students[i] = new HostellerStudent(name);
            } else if (type.equalsIgnoreCase("SCHOLAR")) {
                students[i] = new ScholarStudent(name);
            }
        }

        double totalCollected = 0.0;
        for (int i = 0; i < n; i++) {
            double fee = students[i].calculateTotalFee();
            totalCollected += fee;
            System.out.printf("%s: %.2f\n", students[i].getName(), fee);
        }

        System.out.printf("Total Collected: %.2f\n", totalCollected);
        scanner.close();
    }
}
