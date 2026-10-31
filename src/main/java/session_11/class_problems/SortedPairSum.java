package session_11.class_problems;

public class SortedPairSum {
    public static void pairSumSorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int currentSum = nums[left] + nums[right];
            if (currentSum == target) {
                System.out.println("(" + nums[left] + ", " + nums[right] + ")");
                return;
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println("Not Found");
    }

    public static void main(String[] args) {
        int[] nums1 = {-4, -1, 0, 3, 5, 9};
        int[] nums2 = {1, 2, 3};

        pairSumSorted(nums1, 4);
        pairSumSorted(nums2, 100);
    }
}
