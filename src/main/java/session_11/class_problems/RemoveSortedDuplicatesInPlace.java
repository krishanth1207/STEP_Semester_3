package session_11.class_problems;

import java.util.Arrays;

public class RemoveSortedDuplicatesInPlace {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int writeIndex = 1;
        for (int readIndex = 1; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != nums[readIndex - 1]) {
                nums[writeIndex] = nums[readIndex];
                writeIndex++;
            }
        }
        return writeIndex;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        int len = removeDuplicates(nums);

        System.out.println("length = " + len);
        System.out.println("nums[0.." + (len - 1) + "] = " + Arrays.toString(Arrays.copyOf(nums, len)));
    }
}
