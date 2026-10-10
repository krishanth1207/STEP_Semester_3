package session_10.assigment_problems;

public class ExamScoreBandCounter {

    // Find the first index where score >= target
    private static int findLowerBound(int[] scores, int target) {
        int low = 0;
        int high = scores.length - 1;
        int result = scores.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] >= target) {
                result = mid;
                high = mid - 1; // search left to find first occurrence
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    // Find the first index where score > target
    private static int findUpperBound(int[] scores, int target) {
        int low = 0;
        int high = scores.length - 1;
        int result = scores.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] > target) {
                result = mid;
                high = mid - 1; // search left to find first element strictly greater
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    /**
     * Counts elements in range [low, high] in O(log n) time using binary search.
     *
     * Time Complexity: O(log n) - Binary search logarithmic time.
     * Space Complexity: O(1) - Constant auxiliary memory.
     */
    public static int countInBand(int[] scores, int low, int high) {
        int firstIdx = findLowerBound(scores, low);
        int lastIdx = findUpperBound(scores, high);

        return lastIdx - firstIdx;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};

        System.out.println(countInBand(scores, 42, 58));  // Output: 6
        System.out.println(countInBand(scores, 90, 100)); // Output: 0
    }
}
