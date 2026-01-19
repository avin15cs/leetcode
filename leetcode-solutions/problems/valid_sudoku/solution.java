class Solution {
    // public boolean isValidSudoku(char[][] board) {
    //     int rows = board.length;
    //     int cols = board[0].length;

    //     for (int r = 0; r < rows; r++) {
    //         for (int c = 0; c < cols; c++) {
    //             if (board[r][c] != '.' && !isValid(board, r, c)) {
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }

    // private boolean isValid(char[][] board, int r, int c) {
    //     char val = board[r][c];

    //     // Check row
    //     for (int col = 0; col < 9; col++) {
    //         if (col != c && board[r][col] == val) return false;
    //     }

    //     // Check column
    //     for (int row = 0; row < 9; row++) {
    //         if (row != r && board[row][c] == val) return false;
    //     }

    //     // Check 3x3 sub-grid
    //     int boxRow = (r / 3) * 3;
    //     int boxCol = (c / 3) * 3;

    //     for (int i = boxRow; i < boxRow + 3; i++) {
    //         for (int j = boxCol; j < boxCol + 3; j++) {
    //             if (!(i == r && j == c) && board[i][j] == val) return false;
    //         }
    //     }

    //     return true;
    // }

    // public boolean isValidSudoku(char[][] board) {
    //     int row[] = new int[9];
    //     int col[] = new int[9];
    //     int box[] = new int[9];

    //     for(int i=0;i<9;i++){
    //         for(int j=0;j<9;j++){
    //             char c = board[i][j];
    //             if(c != '.'){
    //                 int bit = 1 << (c - '0');
    //                 int boxN = (i / 3) * 3 + (j / 3);
    //                 if((row[i] & bit) != 0 || (col[j] & bit) != 0 || (box[boxN] & bit) !=0)
    //                     return false;
    //                 row[i] |= bit;
    //                 col[j] |=bit;
    //                 box[boxN] |= bit;
    //             }            
    //         }
    //     }
    //     return true;
    // }

    // public boolean isValidSudoku(char[][] board) {

    //     Set<String> visited = new HashSet<>();

    //     for(int i=0;i<board.length;i++) {
    //         for(int j=0;j<board[0].length;j++) {

    //             if (board[i][j] == '.') continue; 
    //             if(!(visited.add(i+"row"+board[i][j]) && visited.add(j+"col"+board[i][j])
    //                 && visited.add(((i/3)*3+j/3)+"box"+board[i][j])))
    //                 return false;
    //         }
    //     }

    //     return true;
    // }


    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;

                int num = ch - '1';
                int boxIndex = (r / 3) * 3 + (c / 3);

                if (rows[r][num] || cols[c][num] || boxes[boxIndex][num]) {
                    return false;
                }

                rows[r][num] = true;
                cols[c][num] = true;
                boxes[boxIndex][num] = true;
            }
        }
        return true;
    }
}