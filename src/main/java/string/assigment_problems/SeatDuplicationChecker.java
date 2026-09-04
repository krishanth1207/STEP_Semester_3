package string.assigment_problems;

import java.util.Scanner;

public class SeatDuplicationChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    break;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter total number of seats: ");
        int count = scanner.nextInt();

        int[] seatNumbers = new int[count];
        System.out.println("Enter seat numbers:");
        for (int i = 0; i < count; i++) {
            seatNumbers[i] = scanner.nextInt();
        }

        checkDuplicateSeats(seatNumbers);
        scanner.close();
    }
}
