class Solution {
    public int longestPalindromeSubseq(String s) {
        String t=new StringBuilder(s).reverse().toString();
        int n=s.length();
        Integer[][] dp=new Integer[n+1][n+1];
        return lps(s,t,n,n,dp);
    }

    int lps(String s, String t, int n, int m, Integer[][] dp) {
        if(n==0||m==0)
            return 0;
        
        if(dp[n][m]!=null)
            return dp[n][m];
        
        if(s.charAt(n-1)==t.charAt(m-1)) {
            dp[n][m]=1+lps(s,t,n-1,m-1,dp);
        } else {
            dp[n][m]=Math.max(lps(s,t,n-1,m,dp),lps(s,t,n,m-1,dp));
        }
        return dp[n][m];

    }
}