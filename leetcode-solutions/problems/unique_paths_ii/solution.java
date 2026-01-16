class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        if(obstacleGrid[n-1][m-1]==1)
            return 0;
        Integer[][] dp = new Integer[n+1][m+1];
        return dfs(obstacleGrid,0,0,dp);
    }

    int dfs(int[][] grid, int r, int c, Integer[][] dp) {
        
        if (r >= grid.length || c >= grid[0].length)
            return 0;   

        if(r==grid.length-1 && c==grid[0].length-1)
            return grid[r][c]=1;

        if(grid[r][c]==1)
            return 0;

        if(dp[r][c]!=null)
            return dp[r][c];

        int right = dfs(grid,r,c+1,dp);
        int down = dfs(grid,r+1,c,dp);

        return dp[r][c]=down + right;
    }
}