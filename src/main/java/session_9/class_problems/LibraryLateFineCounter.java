package session_9.class_problems;

import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() {
        return title;
    }

    public abstract double calculateFine();
}

class BookItem extends LibraryItem {
    public BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 2.0;
    }
}

class DVDItem extends LibraryItem {
    public DVDItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        double fine = daysLate * 5.0;
        if (fine > 50.0) {
            return 50.0;
        }
        return fine;
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 1.0;
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();

        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String title = scanner.next();
            int daysLate = scanner.nextInt();

            if (type.equalsIgnoreCase("BOOK")) {
                items[i] = new BookItem(title, daysLate);
            } else if (type.equalsIgnoreCase("DVD")) {
                items[i] = new DVDItem(title, daysLate);
            } else if (type.equalsIgnoreCase("MAGAZINE")) {
                items[i] = new MagazineItem(title, daysLate);
            }
        }

        double totalFines = 0.0;
        for (int i = 0; i < n; i++) {
            double fine = items[i].calculateFine();
            totalFines += fine;
            System.out.printf("%s: %.2f\n", items[i].getTitle(), fine);
        }

        System.out.printf("Total Fines: %.2f\n", totalFines);
        scanner.close();
    }
}
