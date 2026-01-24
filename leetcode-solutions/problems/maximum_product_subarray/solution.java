class Solution {
    // public int maxProduct(int[] nums) {
    //     int max = nums[0];
    //     int min = nums[0];
    //     int result = max;
    //     for(int i=1;i<nums.length;i++) {
    //         int temp = nums[i];
    //         int prevMax = max;
    //         int prevMin = min;
    //         max = Math.max(temp, Math.max(prevMax*temp,prevMin*temp));
    //         min = Math.min(temp, Math.min(prevMax*temp,prevMin*temp));

    //         result = Math.max(max, result);

    //     }

    //     return result;
    // }
    public int maxProduct(int[] nums) {
        int prod=1;
        int max=nums[0];
        for(int i : nums){
            prod=prod*i;
            max=Math.max(max,prod);
            if(prod==0) prod=1;
        }

        prod=1;
        for(int i=nums.length-1;i>=0;i--){
            prod=prod*nums[i];
            max=Math.max(max, prod);
            if(prod==0) prod=1;
        }

        return max;
    }
}