class Solution { 

    public int findUnsortedSubarray(int[] nums) {
    int n = nums.length;
    int left = 0, right = -1; // ensures 0 if already sorted
    int max = nums[0], min = nums[n - 1];

    for (int i = 1; i < n; i++) {
        // max = Math.max(max, nums[i]);
        if (nums[i] < max) {
            right = i;
        } else {
            max = nums[i];
        }
    }

    for (int i = n - 2; i >= 0; i--) {
        // min = Math.min(min, nums[i]);
        if (nums[i] > min) {
            left = i;
        } else {
            min = nums[i];
        }
    }

    return right - left + 1;
}

}