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
        int max = nums[0];
        int p = 1;
        int n = nums.length;
        for(int i=0;i<n;i++) {
            p = p*nums[i];
            max = Math.max(max,p);
            if(p==0)
                p=1;
        }

        p=1;
        for(int i=n-1;i>=0;i--) {
            p=p*nums[i];
            max = Math.max(max, p);
            if(p==0)
                p=1;
        }

        return max;
    }
}