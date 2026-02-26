class Solution {
    // public int rob(int[] nums) {
    //     int n = nums.length;

    //     if (n == 1) return nums[0];

    //     int[] dp1 = new int[n];
    //     int[] dp2 = new int[n];
    //     Arrays.fill(dp1, -1);
    //     Arrays.fill(dp2, -1);

    //     int caseA = solve(nums, 0, n - 2, dp1);
    //     int caseB = solve(nums, 1, n - 1, dp2);

    //     return Math.max(caseA, caseB);
    // }

    // private int solve(int[] nums, int i, int end, int[] dp) {
    //     if (i > end) return 0;

    //     if (dp[i] != -1) return dp[i];

    //     int pick = nums[i] + solve(nums, i + 2, end, dp);
    //     int skip = solve(nums, i + 1, end, dp);

    //     return dp[i] = Math.max(pick, skip);
    // }

    // public int rob(int[] nums) {
    //     int n=nums.length;

    //     int ans0=findMax(nums,0,n-2);
    //     int ans1=findMax(nums,1,n-1);

    //     return Math.max(ans0,ans1);
    // }

    // int findMax(int[] nums, int i, int n) {
    //     int prev1=0;
    //     int prev2=0;

    //     for(;i<=n;i++) {
    //         int take=prev2+nums[i];
    //         int skip=prev1;

    //         int cur=Math.max(take,skip);
    //         prev2=prev1;
    //         prev1=cur;
    //     }

    //     return prev1;
    // }

    // public int rob(int[] nums) {
    //     int n=nums.length;
    //     if(n==1)
    //         return nums[0];
            
    //     Integer[] dp1 = new Integer[n];
    //     Integer[] dp2 = new Integer[n];

    //     return Math.max(dfs(nums,0, n-2, dp1),dfs(nums,1,n-1,dp2));
    // }

    // private int dfs(int[] nums, int i, int n, Integer[] dp) {
    //     if(n<i){
    //         return 0;
    //     }

    //     if(dp[n]!=null)
    //         return dp[n];

    //     int pick = nums[n]+dfs(nums,i,n-2,dp);
    //     int skip = dfs(nums,i,n-1,dp);

    //     return dp[n]=Math.max(pick, skip);
    // }
    public int rob(int[] nums) {
        int n = nums.length;
        
        if(n==1)
            return nums[0];
        return Math.max(findMax(nums, 0, n-2), findMax(nums, 1, n-1));

    }

    int findMax(int[] nums, int start, int end) {
        int prev1=0, prev2=0;

        for(int i=start;i<=end;i++) {
            int cur = Math.max(prev2+nums[i], prev1);
            prev2=prev1;
            prev1=cur;
        }

        return prev1;
    }
}