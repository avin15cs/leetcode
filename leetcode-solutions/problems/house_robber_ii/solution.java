class Solution {
    // public int rob(int[] nums) {
    //     int n=nums.length;
    //     int[] dp=new int[n+1];

    //     Arrays.fill(dp,-1);
    //     return solve(nums, n, dp);
    // }

    // int solve(int[] nums, int n, int[] dp) {
    //     if (n == 0) return 0;       
    //     if (n == 1) return nums[0];

    //     if(dp[n]!=-1) return dp[n];

    //     return dp[n]=Math.max(nums[n-1]+solve(nums,n-2,dp),solve(nums,n-1,dp));
    // }


    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int caseA = solve(nums, 0, n - 2, dp1);
        int caseB = solve(nums, 1, n - 1, dp2);

        return Math.max(caseA, caseB);
    }

    private int solve(int[] nums, int i, int end, int[] dp) {
        if (i > end) return 0;

        if (dp[i] != -1) return dp[i];

        int pick = nums[i] + solve(nums, i + 2, end, dp);
        int skip = solve(nums, i + 1, end, dp);

        return dp[i] = Math.max(pick, skip);
    }

}