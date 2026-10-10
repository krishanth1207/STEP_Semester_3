package session_10.assigment_problems;

public class SecondBestScore {

    /**
     * Finds the second highest distinct score in a single linear pass without sorting.
     *
     * Time Complexity: O(n) - Single pass through the array.
     * Space Complexity: O(1) - Only two scalar tracker variables used.
     */
    public static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;

        for (int i = 0; i < scores.length; i++) {
            int s = scores[i];

            if (s > highest) {
                second = highest;
                highest = s;
            } else if (s < highest && s > second) {
                second = s;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        int[] scores1 = {45, 78, 92, 78, 60};
        System.out.println(secondHighest(scores1)); // Output: 78

        int[] scores2 = {50, 50, 50};
        System.out.println(secondHighest(scores2)); // Output: -1
    }
}
