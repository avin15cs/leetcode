class Solution {
    public void sortColors(int[] nums) {

        //[0 … low-1]     → 0s
        //[low … mid-1]   → 1s
        //[mid … high]    → unknown (unprocessed)
        //[high+1 … n-1]  → 2s

        int n=nums.length;

        int i=0,j=0,k=n-1;

        //j<=k => because kth position is unprocessed and also jth position value is also unprocessed
        while(j<=k) {
            if(nums[j]==0) {
                swap(nums,i,j);
                //0-><i => 0s
                //i-><j=>1s
                //that why swapped ith value is 1 and hence we do j++
                i++;
                j++;
            } else if(nums[j]==1) {
                j++;
            } else {
                swap(nums, j, k);
                k--;
            }
        }
    
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}