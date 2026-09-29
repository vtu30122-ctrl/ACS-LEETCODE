import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                int previousIndex = map.get(nums[i]);

                if (i - previousIndex <= k) {
                    return true;
                }
            }

            // Store the latest index
            map.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums1 = {1, 2, 3, 1};
        System.out.println(s.containsNearbyDuplicate(nums1, 3));

        int[] nums2 = {1, 0, 1, 1};
        System.out.println(s.containsNearbyDuplicate(nums2, 1));

        int[] nums3 = {1, 2, 3, 1, 2, 3};
        System.out.println(s.containsNearbyDuplicate(nums3, 2));
    }
}