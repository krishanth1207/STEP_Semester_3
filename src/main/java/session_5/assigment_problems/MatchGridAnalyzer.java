package session_5.assigment_problems;

public class MatchGridAnalyzer {

    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        double sum = 0;
        for (int i = 0; i < row.length; i++) {
            sum += row[i];
        }
        return sum / row.length;
    }

    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);

            String status = (avg >= threshold) ? "Power Surge" : "Normal";

            result.append("Match ").append(i).append(": ").append(status);

            if (i < runsPerOver.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        int threshold = 8;

        System.out.println(classifyMatches(grid, threshold));
    }
}