class Solution {
    public int numDecodings(String s) {
        Integer[] dp=new Integer[s.length()];
        return decode(s,0,dp);
    }
    
    private static int decode(String s, int pos,Integer[] dp){
        if(s.length()==pos)   return 1;

        char c=s.charAt(pos);

        if(c=='0')  return 0;

        if(dp[pos]!=null)   return dp[pos];


        if(pos<s.length()-1 && (c=='1'||c=='2' && s.charAt(pos+1)<'7'))
            return dp[pos]=decode(s,pos+1,dp)+decode(s,pos+2,dp);

        else
            return dp[pos]=decode(s,pos+1,dp);

    }
    
}