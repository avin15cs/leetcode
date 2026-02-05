class Solution {
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int n=text1.length();
    //     int m=text2.length();

    //     int[][] dp = new int[n+1][m+1];
    //     for(int i=1;i<=n;i++) {
    //         for(int j=1;j<=m;j++) {
    //             if(text1.charAt(i-1)==text2.charAt(j-1))
    //                 dp[i][j]=1+dp[i-1][j-1];
    //             else
    //                 dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
    //         }
    //     }
    //     return dp[n][m];
    // }

    // public int longestCommonSubsequence(String text1, String text2) {
    //     int n = text1.length();
    //     int m = text2.length();

    //     int[] dp = new int[m + 1];

    //     for (int i = 1; i <= n; i++) {
    //         int prev = 0;  // dp[i-1][j-1]

    //         for (int j = 1; j <= m; j++) {
    //             int temp = dp[j]; // dp[i-1][j]

    //             if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
    //                 dp[j] = 1 + prev;
    //             } else {
    //                 dp[j] = Math.max(dp[j], dp[j - 1]);
    //             }

    //             prev = temp;
    //         }
    //     }

    //     return dp[m];
    // }

    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();

        Integer[][] dp = new Integer[n+1][m+1];

        return solve(text1, text2, n, m, dp);
    }

    int solve(String text1, String text2, int n, int m, Integer[][] dp) {
        if(n<=0||m<=0)
            return 0;

        if(dp[n][m]!=null)
            return dp[n][m];

        if(text1.charAt(n-1)==text2.charAt(m-1))
            return dp[n][m]=1+solve(text1, text2, n-1, m-1, dp);
        
        else
            return dp[n][m]=Math.max(solve(text1, text2, n-1, m, dp), solve(text1, text2, n, m-1, dp));

    }
}