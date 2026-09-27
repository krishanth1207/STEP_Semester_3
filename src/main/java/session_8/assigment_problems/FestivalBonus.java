package session_8.assigment_problems;

import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected double monthlySalary;

    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.05;
    }
}

class InternEmployee extends Employee {
    public InternEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return 2000.0;
    }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();

            if (type.equalsIgnoreCase("FULLTIME")) {
                employees[i] = new FullTimeEmployee(name, salary);
            } else if (type.equalsIgnoreCase("PARTTIME")) {
                employees[i] = new PartTimeEmployee(name, salary);
            } else if (type.equalsIgnoreCase("INTERN")) {
                employees[i] = new InternEmployee(name, salary);
            }
        }

        double grandTotal = 0.0;
        for (int i = 0; i < n; i++) {
            double bonus = employees[i].calculateBonus();
            grandTotal += bonus;
            System.out.printf("%s: %.2f\n", employees[i].getName(), bonus);
        }

        System.out.printf("Total Bonus: %.2f\n", grandTotal);
        scanner.close();
    }
}
