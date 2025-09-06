class Solution {
    // public int[] getAverages(int[] nums, int k) {
    //     int[] ans=new int[nums.length];
    //     Arrays.fill(ans,-1);

    //     int i=0,j=0;
    //     int w=2*k+1;

    //     int sum=0,avg=0;

    //     while(j<nums.length){
    //         sum+=nums[j];

    //         if(j-i+1==w) {
    //             avg=sum/w;
    //             ans[k+i]=avg;
    //             sum-=nums[i];
    //             i++;
    //         }
    //         j++;
    //     }

    //     return ans;
    // }

    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        int w = 2 * k + 1;
        if (w > n) return ans; // Not enough elements to form a single window

        long sum = 0;
        int i = 0, j = 0;

        while (j < n) {
            sum += nums[j];

            if (j - i + 1 == w) {
                int center = i + k;
                ans[center] = (int)(sum / w);
                sum -= nums[i];
                i++;
            }
            j++;
        }

        return ans;
    }   

}