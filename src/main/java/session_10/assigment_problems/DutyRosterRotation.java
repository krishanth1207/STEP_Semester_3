package session_10.assigment_problems;

import java.util.Arrays;

public class DutyRosterRotation {

    /**
     * Rotates roster names to the right by k positions using modulo arithmetic.
     *
     * Time Complexity: O(n) - Single pass to place elements into the rotated array.
     * Space Complexity: O(n) - Auxiliary array to hold the rotated result.
     */
    public static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        if (n == 0) return names;

        int effectiveK = (int) (k % n);
        String[] rotated = new String[n];

        for (int i = 0; i < n; i++) {
            int newIndex = (i + effectiveK) % n;
            rotated[newIndex] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        String[] names1 = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names1, 2))); // [D, E, A, B, C]

        String[] names2 = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names2, 7))); // [D, E, A, B, C]
    }
}
