package string_performance.class_problems;

import java.util.Scanner;

public class MaskedPhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        String lastFourDigits = phone.substring(6);

        StringBuilder maskedBuilder = new StringBuilder("XXXXXX");
        maskedBuilder.append("-").append(lastFourDigits);

        return maskedBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter phone number: ");
        String input = scanner.nextLine();

        String result = maskPhoneNumber(input);
        System.out.println(result);

        scanner.close();
    }
}
