class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int col=matrix[0].length;

        for(int i=0;i<rows;i++){
            if(target>=matrix[i][0]&&target<=matrix[i][col-1]){
                return binarySearch(matrix,i,col,target);
            }
        }

        return false;
    }

    boolean binarySearch(int[][] matrix, int row, int col, int target) {

        int i=0,j=col-1;

        while(i<=j){

            int mid=i+(j-i)/2;

            if(matrix[row][mid]==target) return true;

            else if(matrix[row][mid]>target) j=mid-1;

            else i=mid+1;
        }

        return false; 
    }
}