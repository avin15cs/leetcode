class Solution {
    public int findDuplicate(int[] nums) {
        int i=0;
        while(i<nums.length) {
            int pos=nums[i]-1;
            if(nums[i]!=nums[pos]) {
                int temp=nums[i];
                nums[i]=nums[pos];
                nums[pos]=temp;
            } else {
                if(i!=pos)
                    return nums[i];
                i++;
            }
        }

        return -1;
    }
}