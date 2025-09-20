class Solution {
    public int findMin(int[] nums) {
        int i=0,n=nums.length;
        int j=n-1;
        int ans=-1;
        if(nums.length==0) return ans;
        if(nums.length==1||nums[0]<nums[j]) return nums[0];
        while(i<=j){
            int mid=i+(j-i)/2;

            if(nums[mid]<nums[0]) {
                ans=nums[mid];
                j=mid-1;
            } else{
                i=mid+1;
            }
        }

        return ans;
    }
}