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

//Kadane's Algo
    public int maxProfit(int[] prices) {
        int diff=0, ans=0;
        int cur=0;
        for(int i=1;i<prices.length;i++) {
            diff = prices[i]-prices[i-1];

            cur = cur+diff;
            if(cur<0) {
                cur=0;
            }

            ans = Math.max(ans, cur);
        }

        return ans;
    }

}