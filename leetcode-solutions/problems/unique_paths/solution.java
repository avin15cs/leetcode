class Solution {
    //Via Recursion only
    // public int uniquePaths(int m, int n) {
    //     if(m==1||n==1)
    //         return 1;
        
    //     int down=uniquePaths(m-1,n);
    //     int right=uniquePaths(m,n-1);

    //     return down+right;
    // }


    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];

        for(int i=0;i<=m;i++)
            Arrays.fill(dp[i],-1);
        
        
        return solve(dp,m,n);
    }

    public int solve(int[][] dp, int m, int n) {
        if(m==1||n==1)
            return 1;
        
        if(dp[m][n]!=-1)
            return dp[m][n];
        
        return dp[m][n]=solve(dp,m-1,n)+solve(dp,m,n-1);
    }


    // public int uniquePaths(int m, int n) {
    //     int[][] dp = new int[m + 1][n + 1];
    //     for (int[] row : dp)
    //         Arrays.fill(row, -1);
    //     return dfs(m, n, dp);
    // }

    // private int dfs(int m, int n, int[][] dp) {
    //     if (m == 1 || n == 1)
    //         return 1;
    //     if (dp[m][n] != -1)
    //         return dp[m][n];

    //     dp[m][n] = dfs(m - 1, n, dp) + dfs(m, n - 1, dp);
    //     return dp[m][n];
    // }

}