class Solution {
    public List<List<String>> partition(String s) {

        int n=s.length();

        boolean[][] dp = new boolean[n+1][n+1];

        for(int i=n-1;i>=0;i--) {
            for(int j=0;j<n;j++) {
                if(s.charAt(i)==s.charAt(j)) {
                    if(j-i<=2) 
                        dp[i][j] = true;
                    else
                        dp[i][j]=dp[i+1][j-1];
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, dp, res, new ArrayList<>());

        return res;
    }

    private void backtrack(String s, int start, boolean[][] dp, List<List<String>> res, List<String> cur) {
        if(start==s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }


        for(int end=start;end<s.length();end++) {
            if(dp[start][end]) {
                cur.add(s.substring(start,end+1));
                backtrack(s, end+1, dp, res, cur);
                cur.remove(cur.size()-1);
            }
        }
    }
}