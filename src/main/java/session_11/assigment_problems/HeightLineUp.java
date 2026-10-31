package session_11.assigment_problems;

import java.util.Arrays;

public class HeightLineUp {

    /**
     * Bubble Sort implementation that prints the array after each pass.
     * Stops early if a pass makes no swaps.
     */
    public static void lineUp(int[] heights) {
        int n = heights.length;
        int pass = 1;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (heights[j] > heights[j + 1]) {
                    // Swap adjacent elements
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            pass++;

            // Early exit if no elements were swapped in this pass
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Sample Input 1 ---");
        int[] h1 = {4, 2, 5, 1};
        lineUp(h1);

        System.out.println("\n--- Sample Input 2 ---");
        int[] h2 = {1, 3, 2, 4};
        lineUp(h2);

        System.out.println("\n--- Custom Input ---");
        int[] h3 = {5, 4, 3, 2, 1};
        lineUp(h3);
    }
}
