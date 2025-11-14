class Solution {
    public int minDistance(String word1, String word2) {
        int i=word1.length();
        int j=word2.length();
        int[][] dp=new int[i+1][j+1];
        for(int[] row: dp) {
            Arrays.fill(row,-1);
        }
        return solve(word1,word2,i,j,dp);
    }

    int solve(String w1, String w2, int i, int j, int[][] dp) {
        if(i==0) return j;

        if(j==0) return i;

        if(dp[i][j]!=-1) return dp[i][j];

        if(w1.charAt(i-1)==w2.charAt(j-1)) {
            return dp[i][j]=solve(w1,w2,i-1,j-1,dp);
        } else {
            return dp[i][j]=1+ Math.min(solve(w1,w2,i,j-1,dp), Math.min(solve(w1,w2,i-1,j,dp), solve(w1,w2,i-1,j-1,dp)));
        }
    }
}