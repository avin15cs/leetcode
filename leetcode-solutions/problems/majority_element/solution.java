class Solution {
    public int majorityElement(int[] nums) {
        int maj=nums[0];
        int pos=1;
        for(int i=1;i<nums.length;i++) {

            if(nums[i]==maj) {
                pos++;
            } else {
                pos--;
            } 
            if(pos==0) {
                maj=nums[i];
                pos=1;
            }
        }

        return maj;
    }
}