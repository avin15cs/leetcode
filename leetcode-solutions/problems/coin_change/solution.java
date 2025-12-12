class Solution {
    // public int coinChange(int[] coins, int amount) {
    //     int n=coins.length;
    //     int dp[][] =new int[n+1][amount+1];
    //     for(int[] i: dp)
    //         Arrays.fill(i,-1);
    //     int res=solve(coins,amount,n, dp);
    //     return res>=Integer.MAX_VALUE-1?-1:res;
    // }

    // int solve(int[] coins, int amount, int n, int[][] dp) {
    //     if(amount==0)
    //         return 0;
        
    //     if(n==0)
    //         return Integer.MAX_VALUE-1;

    //     if(dp[n][amount]!=-1)
    //         return dp[n][amount];

    //     int res;
    //     if(coins[n-1]<=amount) {
    //         res=Math.min(1 + solve(coins,amount-coins[n-1],n,dp),solve(coins, amount,n-1,dp));
    //     } else {
    //         res=solve(coins, amount, n-1,dp);
    //     }
        

    //     return dp[n][amount]=res;
    // }

    public int coinChange(int[] coins, int amount) {
        int n=coins.length;

        int[] dp=new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0]=0;
        for(int coin: coins) {
            for(int i=coin;i<=amount;i++) {
                dp[i]=Math.min(dp[i], 1+dp[i-coin]);
            }
        }

        return dp[amount]==Integer.MAX_VALUE-1?-1:dp[amount];
    }
}