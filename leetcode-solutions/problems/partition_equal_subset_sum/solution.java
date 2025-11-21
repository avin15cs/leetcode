class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num: nums)
            sum+=num;
        
        if(sum%2!=0)
            return false;
        
        int n=nums.length;
        Boolean[][] dp=new Boolean[n+1][(sum/2)+1];
        return solve(nums,n,sum/2,dp);
    }

    boolean solve(int[] nums, int n, int target, Boolean[][] dp) {
        if(target==0)
            return true;
        
        if(n==0)
            return false;

        if(dp[n][target]!= null)
            return dp[n][target];

        boolean res;
        if(nums[n-1]<=target) {
            res=solve(nums,n-1,target-nums[n-1],dp)||solve(nums,n-1,target,dp);
        } else {
            res=solve(nums,n-1,target,dp);
        }

        return dp[n][target]=res;
    }
}