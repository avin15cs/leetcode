class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[n + 1][m + 1];
        return solve(s, p, n, m, dp);
    }

    boolean solve(String s, String p, int i, int j, Boolean[][] dp) {

        // Both exhausted
        if (i == 0 && j == 0)
            return true;

        // Pattern exhausted
        if (j == 0)
            return false;

        if (dp[i][j] != null)
            return dp[i][j];

        // String exhausted → pattern must be x*
        if (i == 0) {
            if (p.charAt(j - 1) == '*')
                return dp[i][j] = solve(s, p, i, j - 2, dp);
            return dp[i][j] = false;
        }

        // Direct match or '.'
        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
            return dp[i][j] = solve(s, p, i - 1, j - 1, dp);
        }

        // '*'
        if (p.charAt(j - 1) == '*') {
            // Zero occurrence
            boolean ans = solve(s, p, i, j - 2, dp);

            // One or more occurrence
            if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                ans = ans || solve(s, p, i - 1, j, dp);
            }

            return dp[i][j] = ans;
        }

        return dp[i][j] = false;
    }
}