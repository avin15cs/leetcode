class Solution {
    public boolean isValidSudoku(char[][] board) {
        int r=board[0].length;
        int c=board.length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j] != '.' && !isValid(board,i,j))
                    return false;
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int r, int c){
        for(int i=0;i<board.length;i++){
            if(i!=c && board[r][i]==board[r][c])
                return false;
        }

        for(int j=0;j<board[0].length;j++){
            if(j!=r && board[j][c]==board[r][c])
                return false;
        }

            // Check 3x3 sub-box
        int boxRow = (r / 3) * 3;
        int boxCol = (c / 3) * 3;
    
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (i != r && j != c && board[i][j] == board[r][c]) {
                    return false;
                }
            }
        }

        return true;
    }
}