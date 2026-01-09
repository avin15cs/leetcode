class Solution {
    public int climbStairs(int n) {
        Integer[][] dp = new Integer[n+1][n+1];
        return climbStairs(n,dp);
    }

    private int climbStairs(int n, Integer[][] dp) {
        if(n<=2)
            return n;

        if(dp[n][n]!=null)
            return dp[n][n];

        return dp[n][n]=climbStairs(n-1,dp)+climbStairs(n-2,dp);
    }
}