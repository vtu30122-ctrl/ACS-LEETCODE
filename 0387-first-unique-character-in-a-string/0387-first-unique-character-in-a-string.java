class Solution {
    public int firstUniqChar(String s) {

        int[] count = new int[26];

        // Count each character
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // Find the first character with count 1
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        System.out.println(s.firstUniqChar("leetcode"));
        System.out.println(s.firstUniqChar("loveleetcode"));
        System.out.println(s.firstUniqChar("aabb"));
    }
}