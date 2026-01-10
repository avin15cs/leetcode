class Solution {
    // public int minDistance(String word1, String word2) {
    //     int n=word1.length();
    //     int m=word2.length();

    //     Integer[][] dp =new Integer[n+1][m+1];
    //     return solve(word1, word2, n, m, dp);
    // }

    // private int solve(String word1, String word2, int n, int m, Integer[][] dp) {
    //     if(n==0)
    //         return m;

    //     if(m==0)
    //         return n;

    //     if(dp[n][m]!=null)
    //         return dp[n][m];
        
    //     if(word1.charAt(n-1)==word2.charAt(m-1))
    //         return dp[n][m]=solve(word1, word2, n-1, m-1, dp);
        
    //     else
    //         return dp[n][m]=1+Math.min(solve(word1, word2, n-1, m-1, dp), Math.min(solve(word1, word2, n-1, m, dp), solve(word1, word2, n, m-1, dp)));

    // } 

    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<=n;i++) {
            for(int j=0;j<=m;j++) {
                if(i==0)
                    dp[0][j]=j;
                else if(j==0)
                    dp[i][0]=i;
                
                else if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=1+Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]));
            }
        }

        return dp[n][m];
    }
}