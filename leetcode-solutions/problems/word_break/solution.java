class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict=new HashSet<>(wordDict);
        Boolean[] dp=new Boolean[s.length()+1];

        return solve(0,s,dict,dp);
    }

    boolean solve(int idx, String s, Set<String> dict, Boolean[] dp) {
        if(idx==s.length())
            return true;

        if(dp[idx]!=null)
            return dp[idx];

        for(String word: dict) {
            if(s.startsWith(word,idx)) {
                if(solve(idx+word.length(),s,dict,dp)) {
                    return dp[idx]=true;
                }
            }
        }

        return dp[idx]=false;
    }
}