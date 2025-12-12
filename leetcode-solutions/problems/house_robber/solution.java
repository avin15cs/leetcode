class Solution {
    // public int rob(int[] nums) {
    //     int n=nums.length;
    //     int[] dp=new int[n+1];
    //     Arrays.fill(dp,-1);
    //     return solve(nums,dp,n);
    // }

    // int solve(int[] nums, int[] dp, int n) {
    //     if(n<=0) return 0;

    //     if(dp[n]!=-1) return dp[n];

    //     return dp[n]=Math.max(nums[n-1]+solve(nums,dp,n-2),solve(nums,dp,n-1));
    // }


    public int rob(int[] nums) {
        int n=nums.length;

        if (n == 1) return nums[0];
        
        int prev1=0;
        int prev2=0;

        for(int num: nums) {
            int rob=num + prev2;
            int skip=prev1;

            int cur=Math.max(rob, skip);

            prev2=prev1;
            prev1=cur;
        }

        return prev1;
    }
}