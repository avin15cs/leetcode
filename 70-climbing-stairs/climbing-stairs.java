class Solution {
    // public int climbStairs(int n) {
    //     Integer[][] dp = new Integer[n+1][n+1];
    //     return climbStairs(n,dp);
    // }

    // private int climbStairs(int n, Integer[][] dp) {
    //     if(n<=2)
    //         return n;

    //     if(dp[n][n]!=null)
    //         return dp[n][n];

    //     return dp[n][n]=climbStairs(n-1,dp)+climbStairs(n-2,dp);
    // }

    public int climbStairs(int n) {
        if(n<=1)    return 1;
        int l=1, j=1;
        int sum=0;

        for(int i=2;i<=n;i++) {
            sum = l+j;
            j=l;
            l=sum;
        }
        return sum;
    }
}