class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(exists(board,i,j,word,0))
                    return true;
            }
        }
        return false;
    }

    private boolean exists(char[][] board, int i, int j, String word, int idx) {
        if(idx==word.length())
            return true;
        
        if(i>=board.length||j>=board[0].length||i<0||j<0||board[i][j]!=word.charAt(idx)) 
            return false;
        
        board[i][j]='*';
        boolean result = exists(board,i+1,j,word,idx+1)||
                        exists(board,i-1,j,word,idx+1)||
                        exists(board,i,j+1,word,idx+1)||
                        exists(board,i,j-1,word,idx+1);
        board[i][j]=word.charAt(idx);

        return result;
    }

}