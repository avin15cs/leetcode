class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null ||grid.length==0) return -1;

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2)
                    rotAdj(grid, i,j,2);
            }
        }

        int minutes=2;
        for(int[] row:grid) {
            for(int cell:row) {
                if(cell==1)
                    return -1;
                minutes=Math.max(minutes,cell);
            }
        }
        return minutes-2;
    }

    void rotAdj(int[][] grid, int r, int c, int minutes) {
        if(r<0||c<0||r>=grid.length||c>=grid[0].length||(grid[r][c]!=1&&grid[r][c]<minutes)) {
            return;
        }

        grid[r][c]=minutes;
        rotAdj(grid,r+1,c,minutes+1);
        rotAdj(grid,r-1,c,minutes+1);
        rotAdj(grid,r,c+1,minutes+1);
        rotAdj(grid,r,c-1,minutes+1);
    }


}