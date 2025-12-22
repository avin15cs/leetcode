class Solution {
//     public void setZeroes(int[][] matrix) {

//         boolean[] rows=new boolean[matrix.length];
//         boolean[] cols=new boolean[matrix[0].length];

//         for(int i=0;i<matrix.length;i++) {
//             for(int j=0;j<matrix[0].length;j++) {
//                 if(matrix[i][j]==0) {
//                     rows[i]=true;
//                     cols[j]=true;
//                 }                   
//             }
//         }

//         for(int i=0;i<matrix.length;i++) {
//             for(int j=0;j<matrix[0].length;j++) {
//                 if(rows[i]||cols[j])
//                     matrix[i][j]=0;
//             }
//         }
//     }

    public void setZeroes(int[][] matrix) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(matrix[i][j]==0) 
                    setMinusOne(matrix,i,j);
            }
        }

        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(matrix[i][j]==99999) 
                    matrix[i][j]=0;
            }
        }
    }

    void setMinusOne(int[][] matrix,int n, int m) {
        for(int i=0;i<matrix[0].length;i++) {
            if(matrix[n][i]!=0)
                matrix[n][i]=99999;
        }

        for(int j=0;j<matrix.length;j++) {
            if(matrix[j][m]!=0)
                matrix[j][m]=99999;
        }
    }
}