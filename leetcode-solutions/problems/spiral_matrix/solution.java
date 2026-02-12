class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix.length==0)
            return list;

        int rowS=0, rowE=matrix.length-1;
        int colS=0, colE=matrix[0].length-1;

        while(rowS<=rowE && colS<=colE) {
            //left to right
            for(int i=colS;i<=colE;i++)
                list.add(matrix[rowS][i]);

            rowS++;

            //top to bottom
            for(int j=rowS;j<=rowE;j++)
                list.add(matrix[j][colE]);

            colE--;

            //right to left
            if(rowS<=rowE) {
                for(int i=colE;i>=colS;i--)
                    list.add(matrix[rowE][i]);
            }

            rowE--;

            if(colS<=colE) {
                for(int j=rowE;j>=rowS;j--)
                    list.add(matrix[j][colS]);
            }
            colS++;
        }

        return list;
    }
}