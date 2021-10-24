class Solution {
    public int missingNumber(int[] nums) {
        int sum=nums.length*(nums.length+1)/2;
        int num=nums.length;
        for(int i=0;i<nums.length;i++)
        {
            sum-=nums[i];
            // num ^= i;
            // num ^= nums[i];;
        }
        return sum;
        // return num;
    }
}