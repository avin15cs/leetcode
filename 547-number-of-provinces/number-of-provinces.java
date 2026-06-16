class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n+1];
        int province=0;
        for(int city=0;city<n;city++) {
            if(!visited[city]) {
                visited[city]=true;
                dfs(isConnected, city, visited);
                province++;
            }
        }

        return province;
    }

    void dfs(int[][] isConnected, int city, boolean[] visited) {
        visited[city] = true;

        for(int neigh = 0; neigh<isConnected.length;neigh++) {
            if(isConnected[city][neigh]==1 && !visited[neigh])
                dfs(isConnected, neigh, visited);
        }
    }
}