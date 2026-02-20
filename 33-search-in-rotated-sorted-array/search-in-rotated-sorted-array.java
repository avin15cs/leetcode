class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int l=0,j=n-1;
        if(nums.length==0) return -1;
        if(nums.length==1) return target==nums[0]?0:-1;
        if(nums[0]<nums[j]) return binarySearch(nums,0,j,target);

        int idx=findIndexOfSmallestNo(nums);

        if(target>=nums[0])
            return binarySearch(nums,0,idx-1,target);
        return binarySearch(nums,idx,j,target);
        // return Math.max(binarySearch(nums,0,idx-1,target),binarySearch(nums,idx,j,target));
    }

    int findIndexOfSmallestNo(int[] nums) {
        int n=nums.length;
        int l=0,h=n-1;
        int ans=-1;
        while(l<=h) {
            int mid=l+(h-l)/2;
            if(nums[0]>nums[mid]){
                // ans=mid;
                h=mid-1;
            }
            else
                l=mid+1;
        }
        // return ans;
        return l;
    }


    int binarySearch(int[] nums, int i, int j, int target){

        while(i<=j){
            int mid=i+(j-i)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) j=mid-1;
            else i=mid+1;
        }
        return -1;
    }
}