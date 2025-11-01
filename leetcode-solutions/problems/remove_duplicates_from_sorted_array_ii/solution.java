class Solution {
    public int removeDuplicates(int[] nums) {
        boolean flag =true;
        int j=0;
        for(int i=1;i<nums.length;i++) {
            if(nums[i]!=nums[j]) {
                nums[++j]=nums[i];
                flag=true;
            } else if(nums[i]==nums[j] && flag) {
                nums[++j]=nums[i];
                flag=false;
            }
        }
        return ++j;
    }
}