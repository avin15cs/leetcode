class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        Integer[][] dp=new Integer[n+1][m+1];
        
        return lcs(text1,text2,n,m,dp);
    }
    
    private int lcs(String s1, String s2, int n, int m, Integer[][] dp){
        if(n==0||m==0)  return 0;
        
        if(dp[n][m]!=null)  return dp[n][m];
        
        if(s1.charAt(n-1)==s2.charAt(m-1))
            return dp[n][m]=1+lcs(s1,s2,n-1,m-1,dp);
        
        else
            return dp[n][m]=Math.max(lcs(s1,s2,n-1,m,dp),lcs(s1,s2,n,m-1,dp));
    }
}