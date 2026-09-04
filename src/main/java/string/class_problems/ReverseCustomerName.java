package string.class_problems;

import java.util.Scanner;

public class ReverseCustomerName {

    public static String reverseCustomerName(String customerName) {
        char[] nameChars = customerName.toCharArray();
        String reversedName = "";

        for (int i = nameChars.length - 1; i >= 0; i--) {
            reversedName += nameChars[i];
        }

        return reversedName;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        String reversedName = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);

        scanner.close();
    }
}