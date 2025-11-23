class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        Integer[][] dp=new Integer[n+1][m+1];

        return lcs(text1,text2,n,m,dp);
    }

    int lcs(String s, String t, int n, int m, Integer[][] dp) {
        if(n==0||m==0)
            return 0;
        
        if(dp[n][m]!=null)
            return dp[n][m];
        
        if(s.charAt(n-1)==t.charAt(m-1))
            dp[n][m]=1+lcs(s,t,n-1,m-1,dp);
        
        else
            dp[n][m]=Math.max(lcs(s,t,n-1,m,dp),lcs(s,t,n,m-1,dp));
        
        return dp[n][m];

    }
}