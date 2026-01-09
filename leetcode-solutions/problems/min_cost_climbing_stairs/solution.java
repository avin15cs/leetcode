class Solution {
    // public int minCostClimbingStairs(int[] cost) {
    //     int n=cost.length;
    //     int prev1=cost[0];
    //     int prev2=cost[1];
        
    //     if(n<2)
    //         return Math.min(prev1,prev2);

    //     int cur=0;
    //     for(int i=2;i<n;i++) {
    //         cur=cost[i]+Math.min(prev1,prev2);
    //         prev1=prev2;
    //         prev2=cur;
    //     }
    //     return Math.min(prev2,prev1);
    // }

    // public int minCostClimbingStairs(int[] cost) {
    //     int n=cost.length;
    //     if(n==2)
    //         return Math.min(cost[0],cost[1]);

    //     Integer[] dp = new Integer[n+1];

    //     return Math.min(minCost(cost, n-1, dp), minCost(cost, n-2, dp));
    // }

    // private int minCost(int[] cost, int n, Integer[] dp) {
    //     if(n<0)
    //         return 0;

    //     if(dp[n]!=null)
    //         return dp[n];
        
    //     return cost[n]+ Math.min(minCost(cost,n-2,dp),minCost(cost,n-1,dp));
    // }

    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length ==0) {
            return 0;
        }
        
        if(cost.length == 1) {
            return cost[0];
        }
        
        int prev1=cost[1];
        int prev2=cost[0];

        for(int i=2;i<cost.length;i++) {
            int cur = Math.min(prev1,prev2)+cost[i];
            prev2 = prev1;
            prev1 = cur;
        }

        return Math.min(prev1, prev2);
    }
}