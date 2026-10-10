package session_10.assigment_problems;

public class ClassAttendanceTracker {

    /**
     * Calculates total present days and the longest consecutive attendance streak in a single pass.
     *
     * Time Complexity: O(n) - Single linear scan through the array.
     * Space Complexity: O(1) - Uses only primitive counter variables.
     */
    public static void attendanceSummary(int[] days) {
        int totalPresent = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] == 1) {
                totalPresent++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        System.out.println("Present: " + totalPresent + ", Longest streak: " + longestStreak);
    }

    public static void main(String[] args) {
        int[] days1 = {1, 1, 0, 1, 1, 1, 0, 1};
        attendanceSummary(days1); // Present: 6, Longest streak: 3

        int[] days2 = {0, 0, 0};
        attendanceSummary(days2); // Present: 0, Longest streak: 0
    }
}
