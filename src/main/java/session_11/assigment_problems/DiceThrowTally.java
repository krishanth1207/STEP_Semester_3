package session_11.assigment_problems;

import java.util.Arrays;

public class DiceThrowTally {

    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7];

        for (int i = 0; i < rolls.length; i++) {
            count[rolls[i]]++;
        }

        System.out.print("Counts: ");
        for (int v = 1; v <= 6; v++) {
            System.out.print(v + ":" + count[v] + (v < 6 ? " " : ""));
        }
        System.out.println();

        int[] sorted = new int[rolls.length];
        int index = 0;

        for (int v = 1; v <= 6; v++) {
            while (count[v] > 0) {
                sorted[index++] = v;
                count[v]--;
            }
        }

        return sorted;
    }

    public static void main(String[] args) {
        int[] rolls1 = {4, 1, 6, 4, 2, 1, 4};
        int[] sorted1 = diceSort(rolls1);
        System.out.println("Sorted: " + Arrays.toString(sorted1));

        System.out.println();

        int[] rolls2 = {6, 5, 5, 3, 2, 1, 6, 2};
        int[] sorted2 = diceSort(rolls2);
        System.out.println("Sorted: " + Arrays.toString(sorted2));
    }
}
