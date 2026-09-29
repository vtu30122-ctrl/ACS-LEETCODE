import java.util.*;

class Solution {
    public void moveZeroes(int[] nums) {

        int index = 0;

        // Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        // Fill the remaining positions with 0
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        int[] nums = {0, 1, 0, 3, 12};

        s.moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }
}