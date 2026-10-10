package session_10.class_problems;

import java.util.Scanner;

public class EvenOddCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        // Clean up brackets and spaces if format is [3, 8, 12, 5, 7, 10]
        if (input.startsWith("[") && input.endsWith("]")) {
            input = input.substring(1, input.length() - 1);
        }

        String[] tokens = input.split(",");
        int even = 0;
        int odd = 0;

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i].trim();
            if (!token.isEmpty()) {
                int num = Integer.parseInt(token);
                if (num % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
        scanner.close();
    }
}
