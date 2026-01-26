class Solution {
    // public int findDuplicate(int[] nums) {
    //     int i=0;
    //     while(i<nums.length) {
    //         int pos=nums[i]-1;
        
    //         if(nums[i]!=nums[pos]) {
    //             int temp = nums[i];
    //             nums[i]=nums[pos];
    //             nums[pos]=temp;
    //         } else {
    //             if(i!=pos)
    //                 return nums[i];
    //             i++;
    //         }

    //     }

    //     return -1;
    // }

    // public int findDuplicate(int[] nums) {
    //     int slow = nums[0];
    //     int fast = nums[0];

    //     // Phase 1: Detect cycle
    //     do {
    //         slow = nums[slow];
    //         fast = nums[nums[fast]];
    //     } while (slow != fast);

    //     // Phase 2: Find entry of cycle
    //     slow = nums[0];
    //     while (slow != fast) {
    //         slow = nums[slow];
    //         fast = nums[fast];
    //     }

    //     return fast;
    // }


    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;

            for (int num : nums) {
                if (num <= mid) count++;
            }

            if (count > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

}