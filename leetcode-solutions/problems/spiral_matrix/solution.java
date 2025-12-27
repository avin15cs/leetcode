class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();

        if(matrix.length==0)
            return list;

        int rowBegin = 0, rowEnd=matrix.length-1;
        int colBegin=0, colEnd = matrix[0].length-1;

        while(rowBegin <= rowEnd && colBegin <= colEnd) {

            //Left to Right
            for(int j=colBegin;j<=colEnd;j++) {
                list.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            //top to down
            for(int i=rowBegin;i<=rowEnd;i++) {
                list.add(matrix[i][colEnd]);
            }
            colEnd--;

            //right to Left 
            if(rowBegin<=rowEnd) {
                for(int j=colEnd;j>=colBegin;j--) {
                    list.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;


            if(colBegin<=colEnd) {
                for(int i = rowEnd;i>=rowBegin;i--) {
                    list.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }

        return list;
    }
}