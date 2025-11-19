class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(nums,dp,n);
    }

    int solve(int[] nums, int[] dp, int n) {
        if(n<=0) return 0;

        if(dp[n]!=-1) return dp[n];

        return dp[n]=Math.max(nums[n-1]+solve(nums,dp,n-2),solve(nums,dp,n-1));
    }
}