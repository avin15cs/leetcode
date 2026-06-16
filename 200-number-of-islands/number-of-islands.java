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


    private void sinkIsland(char[][] grid, int row, int col) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{row, col});

        grid[row][col] = '0';

        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};

        while(!que.isEmpty()) {
            int[] cell = que.remove();

            int r = cell[0];
            int c = cell[1];

            for(int[] dir: dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr>=0 && nr < grid.length &&
                    nc>=0 && nc < grid[0].length &&
                    grid[nr][nc]=='1') {
                        que.add(new int[]{nr,nc});
                        grid[nr][nc]='0';
                }
            }
        }
    }
}