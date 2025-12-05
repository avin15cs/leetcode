class Solution {
    // public int findTargetSumWays(int[] nums, int target) {
    //     int n=nums.length;
    //     int tsum=0;
    //     for(int i:nums)
    //         tsum+=i;

    //     int p=(target+tsum)/2;
        
    //     if ((tsum + target) % 2 != 0 || Math.abs(target) > tsum) return 0;

    //     Integer[][] dp=new Integer[n+1][p+1];
    //     return solve(nums,p,dp,n);
    // }

    // int solve(int[] nums, int target, Integer[][] dp, int n) {
    //     if(target==0)
    //         return 1;
    //     if(n==0)
    //         return 0;
    //     if(target<0)
    //         return 0;
    //     if(dp[n][target]!=null)
    //         return dp[n][target];
        
    //     if(nums[n-1]<=target) {
    //         return dp[n][target]=solve(nums,target-nums[n-1],dp,n-1)+
    //                 +solve(nums,target,dp,n-1);
    //     }

    //     return dp[n][target]=solve(nums,target,dp,n-1);

    // }

    public int findTargetSumWays(int[] nums, int target) {
    int n = nums.length;
    int tsum = 0;
    for (int i : nums)
        tsum += i;

    // Check if valid
    if ((tsum + target) % 2 != 0 || Math.abs(target) > tsum)
        return 0;

    int p = (tsum + target) / 2;

    Integer[][] dp = new Integer[n + 1][p + 1];
    return solve(nums, p, dp, n);
}

int solve(int[] nums, int target, Integer[][] dp, int n) {

    if (n == 0)
        return target == 0 ? 1 : 0;

    if (dp[n][target] != null)
        return dp[n][target];

    if (nums[n - 1] <= target) {
        return dp[n][target] =
                solve(nums, target - nums[n - 1], dp, n - 1) +
                solve(nums, target, dp, n - 1);
    }

    return dp[n][target] = solve(nums, target, dp, n - 1);
}

}