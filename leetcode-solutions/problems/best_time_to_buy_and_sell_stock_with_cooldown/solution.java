class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] dp=new Integer[prices.length][2];
        return solve(prices,0,1,dp);
    }

    private int solve(int[] prices, int index, int buy, Integer[][] dp) {
        if(index>=prices.length)
            return 0;

        if(dp[index][buy]!=null)
            return dp[index][buy];
        if(buy==1) {
            return dp[index][buy] = Math.max(-prices[index]+solve(prices,index+1,0,dp),solve(prices,index+1,1,dp));
        } else {
            return dp[index][buy] = Math.max(prices[index]+solve(prices,index+2,1,dp),solve(prices,index+1,0,dp));
        }
    }

}