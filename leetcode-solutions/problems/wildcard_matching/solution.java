class Solution {
 public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        Boolean[][] dp=new Boolean[n][m];
        return solve(s,p,s.length()-1,p.length()-1,dp);
    }

    boolean solve(String s, String p, int n, int m,Boolean[][] dp) {
        if(n<0 && m<0)
            return true;

        if(m<0)
            return false;
        
        if(n<0) {
            for(int i=0;i<=m;i++) {
                if(p.charAt(i)!='*')
                    return false;
            }

            return true;
        }

        if(dp[n][m]!=null)
            return dp[n][m];

        if(s.charAt(n)==p.charAt(m)||p.charAt(m)=='?')
            return dp[n][m]=solve(s,p,n-1,m-1,dp);
        
        if(p.charAt(m)=='*')
            return dp[n][m]=solve(s,p,n-1,m,dp)||solve(s,p,n,m-1,dp);
        
        return dp[n][m]=false;
    }
}