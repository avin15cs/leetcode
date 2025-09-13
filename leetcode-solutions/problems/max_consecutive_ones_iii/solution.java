class Solution {
    public int longestOnes(int[] nums, int k) {
        if(k==nums.length) return nums.length;
        int i=0,j=0,n=nums.length;
        int max=0;
        while(j<n){
            if(nums[j]==0) k--;
             
            while(k==-1) {
                if(nums[i]==0) k++;
                i++;
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}