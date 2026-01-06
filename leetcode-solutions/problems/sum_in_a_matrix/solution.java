class Solution {
    public int matrixSum(int[][] numd) {
        
        int rows=numd.length;
        int cols=numd[0].length;
        for (int[] row : numd) {
            Arrays.sort(row);
        }
        int maxSum = 0;
        for(int i=0;i<cols;i++) {
            int num=0;
            for(int j=0;j<rows;j++) {
                num=Math.max(num,numd[j][i]);
            }

            maxSum+=num;
        }

        return maxSum;
    }
}