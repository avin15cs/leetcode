class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) 
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] != 0) 
                    ans = Math.max(ans, trav(i, j, grid));
        return ans;
    }
    private int trav(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j]==0) return 0;
        grid[i][j] = 0;

        int left = trav(i-1,j,grid);
        int right = trav(i+1,j,grid);
        int up = trav(i,j-1,grid);
        int down = trav(i,j+1,grid);

        return 1 + left + right + up + down;
    }
}