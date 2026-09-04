package string.assigment_problems;

import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.length() == 0) {
            System.out.println("Empty signal log.");
            return;
        }

        char maxChar = signalLog.charAt(0);
        int maxStreak = 1;

        char currentChar = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentChar) {
                currentStreak++;
            } else {
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    maxChar = currentChar;
                }
                currentChar = signalLog.charAt(i);
                currentStreak = 1;
            }
        }

        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            maxChar = currentChar;
        }

        System.out.println("Longest Streak: '" + maxChar + "' repeated " + maxStreak + " times");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter signal log (e.g., RRGGGYRR): ");
        String signalLog = scanner.nextLine();

        findLongestStreak(signalLog);

        scanner.close();
    }
}
