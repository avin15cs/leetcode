class Solution {
    public int numIslands(char[][] grid) {
        int n=grid[0].length;
        int m=grid.length;
        int count=0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]=='1') {
                    count++;
                    sinkIsland(grid,i,j,m,n);
                }
            }
        }
        return count;
    }

    public void sinkIsland(char[][] grid, int i, int j, int m, int n) {
        if(i<0||j<0||i==m||j==n||grid[i][j]=='0')
            return;
        grid[i][j]='0';
        sinkIsland(grid,i+1,j,m,n);
        sinkIsland(grid,i-1,j,m,n);
        sinkIsland(grid,i,j+1,m,n);
        sinkIsland(grid,i,j-1,m,n);
    }
}