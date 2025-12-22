class Solution {
    // public int missingNumber(int[] nums) {
    //     int n=nums.length;
    //     int i=0;
    //     while(i<n) {
    //         int correct=nums[i];
    //         if(correct<n && nums[i]!=nums[correct]) {
    //             int temp=nums[i];
    //             nums[i]=nums[correct];
    //             nums[correct]=temp;
    //         }
    //         else
    //             i++;
    //     }

    //     for(i=0;i<nums.length;i++) {
    //         if(i!=nums[i])
    //             return i;
    //     }

    //     return nums.length;
    // }

    public int missingNumber(int[] nums) {
        
        int n=nums.length;
        int num=n;

        for(int i=0;i<n;i++) {
            num=num^i;
            num=num^nums[i];
        }

        return num;
    }
}