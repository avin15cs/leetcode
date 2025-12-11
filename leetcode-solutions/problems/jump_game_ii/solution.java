class Solution {
    // public int jump(int[] nums) {
    //     int l=0,r=0,jumps=0,n=nums.length;
    //     while(r<n-1) {
    //         int farthest=0;
    //         for(int i = l;i<=r;i++) {
    //             farthest = Math.max(farthest,i+nums[i]);
    //         }
    //         l=r+1;
    //         r=farthest;
    //         jumps++;
    //     }

    //     return jumps;
    // }

    public int jump(int[] nums) {
        int curEnd=0, jump=0, farthest = 0;
        int n=nums.length;
        for(int i=0;i<nums.length-1;i++) {
            farthest=Math.max(farthest, i+nums[i]);

            if(i==curEnd) {
                jump++;
                curEnd=farthest;
            }

            // if(curEnd>=n-1) break;
        }

        return jump;
    }
}