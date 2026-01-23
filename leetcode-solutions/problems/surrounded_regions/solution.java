class Solution {
    // public void solve(char[][] board) {
    //     int m=board.length;
    //     int n=board[0].length;
    //     for(int i=0;i<m;i++) {
    //         dfs(board, i, 0, m, n);
    //         dfs(board, i, n-1, m, n);
    //     }

    //     for(int j=0;j<n;j++) {
    //         dfs(board, 0, j, m, n);
    //         dfs(board, m-1, j, m, n);
    //     }
    //     for(int i=0;i<m;i++) {
    //         for(int j=0;j<n;j++) {
    //             if(board[i][j]=='O') {
    //                 board[i][j] = 'X';
    //             } else if(board[i][j]=='T'){
    //                 board[i][j] = 'O';
    //             }
    //         }
    //     }
    // }

    // void dfs(char[][] board, int i, int j, int m, int n) {
    //     if(i<0||j<0||i>=m||j>=n||board[i][j]!='O')
    //         return;
        
    //     board[i][j]='T';
    //     dfs(board,i+1,j,m,n);
    //     dfs(board,i-1,j,m,n);
    //     dfs(board,i,j+1,m,n);
    //     dfs(board,i,j-1,m,n);
    // }



    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        //left & right check
        for(int i=0;i<n;i++) {
            dfs(board, i, 0, n, m);
            dfs(board, i, m-1, n, m);
        }
        //top and bottom check
        for(int i=0;i<m;i++) {
            dfs(board, 0, i, n, m);
            dfs(board, n-1, i, n, m);
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(board[i][j]=='#')
                    board[i][j] = 'O';

                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    void dfs(char[][] board, int i, int j, int n, int m) {
        if(i<0||j<0||i>=n||j>=m||board[i][j]!='O')
            return;

        board[i][j] = '#';
        dfs(board, i+1, j, n, m);
        dfs(board, i-1, j, n, m);
        dfs(board, i, j+1, n, m);
        dfs(board, i, j-1, n, m);
    }
}