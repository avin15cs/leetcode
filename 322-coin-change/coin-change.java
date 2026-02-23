class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Integer[][] dp = new Integer[n+1][amount+1];
        int ans = solve(coins, amount, 0, dp);
        return ans == Integer.MAX_VALUE-1?-1: ans;
    }

    int solve(int[] nums, int amount, int pos, Integer[][] dp) {
        if(amount==0)
            return 0;
        
        if(nums.length==pos)
            return Integer.MAX_VALUE-1;

        if(dp[pos][amount]!=null)
            return dp[pos][amount];

        if(nums[pos]<=amount)
            dp[pos][amount]=Math.min(1+solve(nums,amount-nums[pos],pos,dp),solve(nums, amount, pos+1, dp));
         else
            dp[pos][amount]=solve(nums, amount, pos+1, dp); 
        
        return dp[pos][amount];
    }
}