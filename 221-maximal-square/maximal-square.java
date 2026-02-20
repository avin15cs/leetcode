class Solution {
    int max=0;
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Integer[][] dp = new Integer[n][m];

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                dfs(matrix, dp, i, j);
            }
        }

        return max*max;
    }

    int dfs(char[][] matrix, Integer[][] dp, int i, int j) {
        if(i>=matrix.length||j>=matrix[0].length)
            return 0;

        if(dp[i][j]!=null)
            return dp[i][j];

        if(matrix[i][j]=='1') {
            int down = dfs(matrix, dp, i+1, j);
            int right = dfs(matrix, dp, i, j+1);
            int diag = dfs(matrix, dp, i+1, j+1);

            dp[i][j]=1+Math.min(down, Math.min(right,diag));

            max = Math.max(max, dp[i][j]);
        } else {
            dp[i][j] = 0;
        }

        return dp[i][j];
    }
}