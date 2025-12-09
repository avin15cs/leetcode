class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int curMax=0,maxSum=Integer.MIN_VALUE;
        int curMin=0,minSum=Integer.MAX_VALUE;
        int n=nums.length;
        int total=0;
        for(int i=0;i<n;i++) {
            total+=nums[i];
            curMax+=nums[i];
            maxSum=Math.max(curMax,maxSum);
            if(curMax<0)
                curMax=0;

            curMin+=nums[i];
            minSum=Math.min(curMin,minSum);
            if(curMin>0)
                curMin=0;
        }

        if(maxSum<0)
            return maxSum;

        return Math.max(maxSum,total-minSum);
    }
}