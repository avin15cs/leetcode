class Solution {
    public int[] searchRange(int[] nums, int target) {
       return new int[]{findBound(nums, target, true),findBound(nums,target,false)};
    }
    
    private int findBound(int[] nums, int target, boolean findFirst) {
        int l=0,r=nums.length-1;
        int ans=-1;
        while(l<=r) {
            int mid=l+(r-l)/2;
            if(nums[mid]==target) {
                if(findFirst) 
                    r=mid-1;
                else
                    l=mid+1;
                
                ans=mid;
            }

            else if(nums[mid]<target)
                l=mid+1;
            
            else
                r=mid-1;
        }

        return ans;
    }
}