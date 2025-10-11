class Solution {
    // public int maxProfit(int[] prices) {
    //     int min=prices[0];
    //     int maxProfit=0;
    //     for(int i=0;i<prices.length;i++){
    //         min=Math.min(min,prices[i]);
    //         maxProfit=Math.max(maxProfit,prices[i]-min);
    //     }
    //     return maxProfit;

    // }


    public int maxProfit(int[] prices) {

        int minPrice=prices[0];
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            maxProfit=Math.max(prices[i]-minPrice,maxProfit);
            minPrice=Math.min(minPrice,prices[i]);
        }
        return maxProfit;
    }
}