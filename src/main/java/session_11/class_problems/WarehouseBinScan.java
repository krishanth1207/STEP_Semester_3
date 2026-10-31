package session_11.class_problems;

public class WarehouseBinScan {
    public static void warehouseSummary(int[][] grid) {
        if (grid == null || grid.length == 0) return;

        int total = 0;
        int maxVal = -1;
        int maxRow = 0;
        int maxCol = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                int val = grid[r][c];
                total += val;
                if (val > maxVal) {
                    maxVal = val;
                    maxRow = r;
                    maxCol = c;
                }
            }
        }

        System.out.println("total = " + total + ", maxCoordinate = (" + maxRow + ", " + maxCol + ")");
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };
        warehouseSummary(grid);
    }
}
