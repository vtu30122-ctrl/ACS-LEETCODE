import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        
        for (int num : nums) {
            // If the set already contains the number, a duplicate exists
            if (seen.contains(num)) {
                return true;
            }
            // Add the number to the set
            seen.add(num);
        }
        
        // No duplicates found after checking all elements
        return false;
    }
}