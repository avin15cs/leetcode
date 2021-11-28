class Solution {
    public int[] runningSum(int[] nums) {
        // int[] sum= new int[nums.length];
        // int curSum=0;
        for(int i=1;i<nums.length;i++)
        {
            // curSum+=nums[i];
            // sum[i]=curSum;
            nums[i]+=nums[i-1];
        }    
        // return sum;
        return nums;
    }
}