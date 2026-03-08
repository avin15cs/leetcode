class Solution {
    // public boolean canJump(int[] nums) {
    //     Boolean[] dp=new Boolean[nums.length+1];
    //     return findPath(0,nums,dp);
    // }

    // private boolean findPath(int currentPos, int[] nums, Boolean[] dp) {
    //     if(currentPos == nums.length-1) return dp[currentPos]=true;

    //     if(nums[currentPos]==0) return dp[currentPos] = false;

    //     if(dp[currentPos]!=null) return dp[currentPos];

    //     for(int i=currentPos+1;i<=currentPos+nums[currentPos];i++){
    //         if(findPath(i,nums,dp))
    //             return dp[currentPos]=true;
    //     }
    //     return dp[currentPos]=false;
    // }



    public boolean canJump(int[] nums)
    {
        int farthest=0,n=nums.length-1;
        for(int i=0;i<nums.length;i++) {
            if(farthest<i)
                return false;
            farthest=Math.max(farthest,i+nums[i]);

            if(farthest>=nums.length-1)
                return true;
        }

        return true;
    }
}