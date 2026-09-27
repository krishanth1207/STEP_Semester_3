package session_8.class_problems;

import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract LocalDate calculateDueDate(LocalDate currentDate);
}

class BookItem extends LibraryItem {
    public BookItem(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(14);
    }
}

class DVDItem extends LibraryItem {
    public DVDItem(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(7);
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(3);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();

        LibraryItem[] items = new LibraryItem[n];
        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String title = scanner.nextLine().trim();
            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            if (type.equalsIgnoreCase("BOOK")) {
                items[i] = new BookItem(title);
            } else if (type.equalsIgnoreCase("DVD")) {
                items[i] = new DVDItem(title);
            } else if (type.equalsIgnoreCase("MAGAZINE")) {
                items[i] = new MagazineItem(title);
            }
        }

        for (int i = 0; i < n; i++) {
            LocalDate dueDate = items[i].calculateDueDate(currentDate);
            System.out.println(items[i].getTitle() + ": " + dueDate);
        }

        scanner.close();
    }
}
