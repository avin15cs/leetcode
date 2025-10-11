class Solution {
    // public int maxProfit(int[] prices) {
    //     int sum=0;
    //     for(int i=1;i<prices.length;i++){
    //         if(prices[i]>prices[i-1])
    //          sum+=(prices[i]-prices[i-1]);
    //     }
    //     return sum;
    // }

    public int maxProfit(int[] prices) {
        int profit=0;
        for(int i=1;i<prices.length;i++) {
            if(prices[i]>prices[i-1])
                profit+=prices[i]-prices[i-1];
        }

        return profit;
    }
}