class Solution {
    public int findMin(int[] nums) {
        int n = nums.length-1;
        if(nums[0]<nums[n])
            return nums[0];

        int i=0,j=n;

        while(i<j) {
            int mid = i+(j-i)/2;

            if(nums[0]>nums[mid])
                j=mid;
            
            else
                i=mid+1;
        }

        return nums[i];
    }
}