package session_11.assigment_problems;

import java.util.Arrays;

public class PrizeTable {

    public static int prizeTable(int[] marks) {
        int n = marks.length;
        int swapCount = 0;

        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;

            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIdx]) {
                    maxIdx = j;
                }
            }

            if (maxIdx != i) {
                int temp = marks[i];
                marks[i] = marks[maxIdx];
                marks[maxIdx] = temp;
                swapCount++;
            }
        }

        System.out.print(Arrays.toString(marks) + " ");
        return swapCount;
    }

    public static void main(String[] args) {
        int[] m1 = {45, 90, 60, 75};
        int swaps1 = prizeTable(m1);
        System.out.println("swaps = " + swaps1);

        int[] m2 = {80, 70, 60};
        int swaps2 = prizeTable(m2);
        System.out.println("swaps = " + swaps2);

        int[] m3 = {10, 50, 20, 40, 30};
        int swaps3 = prizeTable(m3);
        System.out.println("swaps = " + swaps3);
    }
}
