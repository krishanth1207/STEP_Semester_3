package session_10.assigment_problems;

public class BusiestBusRow {

    public static void busiestRow(int[][] grid) {
        if (grid == null || grid.length == 0) return;

        int maxRowIndex = 0;
        int maxTotal = -1;

        for (int r = 0; r < grid.length; r++) {
            int currentRowTotal = 0;
            for (int c = 0; c < grid[r].length; c++) {
                currentRowTotal += grid[r][c];
            }

            if (currentRowTotal > maxTotal) {
                maxTotal = currentRowTotal;
                maxRowIndex = r;
            }
        }

        System.out.println("Row " + maxRowIndex + ", Total " + maxTotal);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        busiestRow(grid);
    }
}