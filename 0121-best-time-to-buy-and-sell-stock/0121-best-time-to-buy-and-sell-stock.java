class Solution {
    public int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            // Find the lowest buying price
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            // Calculate today's profit
            int profit = prices[i] - minPrice;

            // Update maximum profit
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(s.maxProfit(prices));
    }
}