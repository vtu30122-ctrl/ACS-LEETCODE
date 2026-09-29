class Solution {
    public int maxTurbulenceSize(int[] arr) {

        int up = 1;
        int down = 1;
        int answer = 1;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > arr[i - 1]) {
                up = down + 1;
                down = 1;
            }
            else if (arr[i] < arr[i - 1]) {
                down = up + 1;
                up = 1;
            }
            else {
                up = 1;
                down = 1;
            }

            answer = Math.max(answer, Math.max(up, down));
        }

        return answer;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        int[] arr = {9, 4, 2, 10, 7, 8, 8, 1, 9};

        System.out.println(s.maxTurbulenceSize(arr));
    }
}