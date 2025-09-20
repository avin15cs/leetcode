class Solution {
    public int findPeakElement(int[] nums) {
        int i=1,j=nums.length-2;
		if(nums.length == 1) return 0; // single element
        
        int n = nums.length;
        
		// check if 0th/n-1th index is the peak element
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        while(i<=j){
            int mid = i+(j-i)/2;
            if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]) return mid;
            else if(nums[mid]<nums[mid-1]) j=mid-1;
            else if(nums[mid]<nums[mid+1]) i=mid+1;
        }
        return -1;
    }
}