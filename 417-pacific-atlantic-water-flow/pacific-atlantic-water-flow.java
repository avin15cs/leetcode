class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> list = new ArrayList<>();
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int row=0; row<m; row++) {
            dfs(heights, pacific, row, 0, heights[row][0]);
            dfs(heights, atlantic, row, n-1, heights[row][n-1]);
        }

        for(int col=0; col<n; col++) {
            dfs(heights, pacific, 0, col, heights[0][col]);
            dfs(heights, atlantic, m-1, col, heights[m-1][col]);
        }


        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(pacific[i][j] && atlantic[i][j]){
                    list.add(Arrays.asList(i,j));
                }
            }
        }

        return list;
    }

    void dfs(int[][] heights, boolean[][] visited, int row, int col, int prev) {
        if(row<0||col<0||row>=heights.length||col>=heights[0].length||prev>heights[row][col]||visited[row][col])
            return;

        visited[row][col] = true;

        dfs(heights, visited, row+1, col, heights[row][col]);
        dfs(heights, visited, row-1, col, heights[row][col]);
        dfs(heights, visited, row, col+1, heights[row][col]);
        dfs(heights, visited, row, col-1, heights[row][col]);
    }
}