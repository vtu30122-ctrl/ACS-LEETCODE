import java.util.*;

class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int totalSum = 0;

        // Find total sum
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {

            int leftCount = i;
            int rightCount = n - i - 1;

            // Difference from elements on the left
            int leftDifference = nums[i] * leftCount - leftSum;

            // Difference from elements on the right
            int rightSum = totalSum - leftSum - nums[i];
            int rightDifference = rightSum - nums[i] * rightCount;

            result[i] = leftDifference + rightDifference;

            leftSum += nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {2, 3, 5};

        System.out.println(
            Arrays.toString(s.getSumAbsoluteDifferences(nums))
        );
    }
}