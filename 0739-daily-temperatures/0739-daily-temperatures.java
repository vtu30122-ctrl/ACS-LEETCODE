class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        int hottest = 0;

        for (int i = n - 1; i >= 0; i--) {
            int currentTemp = temperatures[i];

            if (currentTemp >= hottest) {
                hottest = currentTemp;
                continue; // Default is already 0
            }

            int days = 1;
            // Jump forward using precalculated answer array
            while (temperatures[i + days] <= currentTemp) {
                days += answer[i + days];
            }
            answer[i] = days;
        }

        return answer;
    }
}
