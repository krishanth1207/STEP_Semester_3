package session_10.assigment_problems;

import java.util.Scanner;

public class BusiestBusRow {

    /**
     * Calculates and prints the row index with the maximum sum and its total.
     * If there is a tie, the smaller index is kept.
     *
     * Time Complexity: O(r * c) where r is rows and c is columns.
     * Space Complexity: O(1) auxiliary space.
     */
    public static void busiestRow(int[][] grid) {
        if (grid == null || grid.length == 0) return;

        int maxRowIndex = 0;
        int maxTotal = -1;

        for (int r = 0; r < grid.length; r++) {
            int currentRowTotal = 0;
            for (int c = 0; c < grid[r].length; c++) {
                currentRowTotal += grid[r][c];
            }

            // Strictly greater ensures smaller index is kept in case of a tie
            if (currentRowTotal > maxTotal) {
                maxTotal = currentRowTotal;
                maxRowIndex = r;
            }
        }

        System.out.println("Row " + maxRowIndex + ", Total " + maxTotal);
    }

    public static void main(String[] args) {
        // Example usage matching sample input
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        busiestRow(grid);
    }
}