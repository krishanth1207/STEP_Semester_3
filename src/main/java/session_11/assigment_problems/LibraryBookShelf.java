package session_11.assigment_problems;

import java.util.Arrays;

public class LibraryBookShelf {

    public static void shelf(int[] books) {
        int n = books.length;

        for (int i = 1; i < n; i++) {
            int newBook = books[i];
            int j = i - 1;

            while (j >= 0 && books[j] > newBook) {
                books[j + 1] = books[j];
                j--;
            }

            books[j + 1] = newBook;

            System.out.println("After placing " + newBook + ": " + Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        int[] b1 = {30, 10, 40, 20};
        shelf(b1);

        System.out.println();
        int[] b2 = {50, 20, 10, 40, 30};
        shelf(b2);
    }
}
