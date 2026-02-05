class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int[] ans = new int[n];

        for(int i=0;i<n;i++) {
            if(nums[i]>0) {
                ans[i]=nums[(i+(nums[i]%n))%n];
            } else {
                ans[i]=nums[((i+nums[i])%n+n)%n];
            }
        }

        return ans;
    }
}