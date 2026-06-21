class Solution {
    // public int maxProfit(int[] prices) {
    //     int minPrice = prices[0];
    //     int maxProfit = 0;

    //     for(int i=1;i<prices.length;i++) {
    //         minPrice = Math.min(minPrice,prices[i]);
    //         maxProfit = Math.max(maxProfit, prices[i]-minPrice);
    //     }

    //     return maxProfit;
    // }

    public int maxProfit(int[] prices) {
    int curr = 0;
    int ans = 0;

    for (int i = 1; i < prices.length; i++) {
        int diff = prices[i] - prices[i - 1];

        curr += diff;

        if (curr < 0) {
            curr = 0;
        }

        ans = Math.max(ans, curr);
    }

    return ans;
}
}