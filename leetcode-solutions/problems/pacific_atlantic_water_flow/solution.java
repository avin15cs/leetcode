class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length; // row
        int n=heights[0].length; //column
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int col=0;col<n;col++) {
            dfs(heights,pacific,0,col,heights[0][col]);
            dfs(heights,atlantic,m-1,col,heights[m-1][col]);
        }

        for(int row=0;row<m;row++) {
            dfs(heights,pacific,row,0,heights[row][0]);
            dfs(heights,atlantic,row,n-1,heights[row][n-1]);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(pacific[i][j] && atlantic[i][j])
                    res.add(Arrays.asList(i,j));
            }
        }

        return res;

    }


    void dfs(int[][] heights, boolean[][] visited, int r, int c, int prevH) {
        if(r<0 || c<0 ||r>=heights.length || c>=heights[0].length || prevH>heights[r][c] || visited[r][c])
            return;

        visited[r][c]=true;

        dfs(heights,visited,r+1,c,heights[r][c]);

        dfs(heights,visited,r,c+1,heights[r][c]);

        dfs(heights,visited,r-1,c,heights[r][c]);

        dfs(heights,visited,r,c-1,heights[r][c]);
    }
}