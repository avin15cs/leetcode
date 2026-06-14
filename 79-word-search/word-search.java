class Solution {
    // public boolean exist(char[][] board, String word) {
        
    //     for(int i=0;i<board.length;i++) {
    //         for(int j=0;j<board[0].length;j++) {
    //             if(exists(board, word, i, j, 0))
    //                 return true;
    //         }
    //     }

    //     return false;
    // }

    // boolean exists(char[][] board, String word, int r, int c, int idx) {
    //     if(idx == word.length())
    //         return true;

    //     if(r<0||c<0||r==board.length||c==board[0].length||board[r][c]!=word.charAt(idx))
    //         return false;

    //     board[r][c]='*';
    //     boolean result=exists(board,word,r+1,c,idx+1)||
    //                     exists(board,word,r-1,c,idx+1)||
    //                     exists(board,word,r,c+1,idx+1)||
    //                     exists(board,word,r,c-1,idx+1);
    //     board[r][c]=word.charAt(idx);
    //     return result;
    // }  


    public boolean exist(char[][] board, String word) {

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(exists(board, word, i, j, 0))
                    return true;
            }
        }

        return false;
    }


    private boolean exists(char[][] board, String word, int i, int j, int idx) {
        if(idx==word.length())
            return true;

        if(i<0||j<0||i==board.length||j==board[0].length||board[i][j]!=word.charAt(idx))
            return false;

        board[i][j]='*';
        boolean result = exists(board, word, i+1, j, idx+1)||
                            exists(board, word, i-1, j, idx+1)||
                            exists(board, word, i, j+1, idx+1)||
                            exists(board, word, i, j-1, idx+1);
        
        board[i][j]=word.charAt(idx);
        return result;
    }


}