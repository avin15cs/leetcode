class Solution {
    public int removeDuplicates(int[] nums) {
        int j=0, count=0;

        for(int i=1;i<nums.length;i++) {
            if(nums[j]!=nums[i]) {
                nums[++j]=nums[i];
                count=0;
            }
            else if(nums[j]==nums[i] && count<1) {
                nums[++j]=nums[i];
                count++;
            }
            
        }
        return ++j;
    }
}