class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict=new HashSet<>(wordDict);
        Boolean[] dp=new Boolean[s.length()+1];

        return solve(0,s,dict,dp);
    }

    boolean solve(int i, String s, Set<String> dict,Boolean[] dp) {
        if(s.length()==i) {
            return true;
        }

        if(dp[i]!=null)
            return dp[i];

        for(String word: dict) {
            if(s.startsWith(word,i)) {
                if(solve(i+word.length(),s,dict,dp))
                    return dp[i]=true;
            }
        }

        return dp[i]=false;
    }
}