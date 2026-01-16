class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] chess=new char[n][n];
        for(int i=0;i<chess.length;i++) {
            Arrays.fill(chess[i],'.');
        }
        List<List<String>> res=new ArrayList<>();
        solve(chess,0,res);
        return res;
    }

    void solve(char[][] chess, int row, List<List<String>> res) {
        if(row==chess.length) {
            res.add(construct(chess));
            return;
        }
        
        for(int col=0;col<chess.length;col++) {
            if(isSafe(chess,row,col)) {
                chess[row][col]='Q';
                solve(chess,row+1,res);
                chess[row][col]='.';
            }
        }
    }

    boolean isSafe(char[][] chess, int row, int col) {
        //Up
        for(int i=row-1;i>=0;i--) {
            if(chess[i][col]=='Q')
                return false;
        }
        //up left
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--) {
            if(chess[i][j]=='Q')
                return false;
        }
        //up right
        for(int i=row-1,j=col+1;i>=0&&j<chess[0].length;i--,j++) {
            if(chess[i][j]=='Q')
                return false;
        }
        return true;
    }

    List<String> construct(char[][] chess) {
        List<String> list = new ArrayList<>();
        for (char[] i : chess) {
            list.add(new String(i));
        }
        return list;
    }
}