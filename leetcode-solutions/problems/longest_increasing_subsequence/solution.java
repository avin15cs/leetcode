class Solution {
    // public int lengthOfLIS(int[] nums) {
    //     int n=nums.length;
    //     Integer[][] dp=new Integer[n+1][n+1];

    //     return solve(nums,0,-1,dp); 
    // }

    // int solve(int[] nums, int n, int prev, Integer[][] dp) {
    //     if(n==nums.length) {
    //         return 0;
    //     }

    //     if(dp[n][prev+1]!=null)
    //         return dp[n][prev+1];
        
    //     if(prev==-1||nums[n]>nums[prev]) {
    //         int take = 1+solve(nums, n+1,n,dp);
    //         int skip=solve(nums,n+1,prev,dp);
    //         return dp[n][prev+1]=Math.max(take,skip);
    //     } else {
    //         int skip=solve(nums,n+1,prev,dp);
    //         return dp[n][prev+1]=skip;
    //     }
    // }
    public int lengthOfLIS(int[] nums) {
        List<Integer> list=new ArrayList<>();
        list.add(nums[0]);
        int prev=nums[0];
        for(int i=1;i<nums.length;i++) {
            if(nums[i]>list.get(list.size()-1)) {
                list.add(nums[i]);
                prev=nums[i];
            } else {
                int pos=findPos(list,0,list.size()-1,nums[i]);
                list.set(pos,nums[i]);
            }
        }

        return list.size();
    }

    public int findPos(List<Integer> list, int i, int j, int target) {
        while(i<=j) {
            int mid=i+(j-i)/2;

            if(list.get(mid)<target) {
                i=mid+1;
            } else {
                j=mid-1;
            }
        }

        return i;
    }
}