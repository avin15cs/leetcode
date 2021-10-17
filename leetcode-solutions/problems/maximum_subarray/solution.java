class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=nums[0];
        int sum=0;
        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
            if(sum<nums[i])
                sum=nums[i];
            if(sum>maxSum)
                maxSum=sum;
        }
        return maxSum;
    }
}