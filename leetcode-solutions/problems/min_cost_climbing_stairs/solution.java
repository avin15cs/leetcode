class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int prev1=cost[0];
        int prev2=cost[1];
        
        if(n<2)
            return Math.min(prev1,prev2);

        int cur=0;
        for(int i=2;i<n;i++) {
            cur=cost[i]+Math.min(prev1,prev2);
            prev1=prev2;
            prev2=cur;
        }
        return Math.min(prev2,prev1);
    }

    // public int minCostClimbingStairs(int[] cost) {
    //     int n = cost.length;
    //     Integer[] dp = new Integer[n];
    //     return Math.min(solve(cost, n - 1, dp),
    //                     solve(cost, n - 2, dp));
    // }

    // private int solve(int[] cost, int i, Integer[] dp) {
    //     if (i < 0) return 0;
    //     if (dp[i] != null) return dp[i];
    //     if (i == 0 || i == 1) return dp[i] = cost[i];

    //     return dp[i] = cost[i] + Math.min(solve(cost, i - 1, dp),
    //                                     solve(cost, i - 2, dp));
    // }
}