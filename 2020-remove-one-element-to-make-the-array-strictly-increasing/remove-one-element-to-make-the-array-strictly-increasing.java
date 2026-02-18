class Solution {
    // public boolean canBeIncreasing(int[] nums) {
    //     boolean removed = false;
    //     for(int i=1;i<nums.length;i++) {
    //         if(nums[i]<=nums[i-1]) {
    //             if(removed)
    //                 return false;
    //             removed = true;

    //             if(i>1 && nums[i]<=nums[i-2])
    //                 nums[i]=nums[i-1];
    //             //else remove nums[i-1];
    //         }
    //     }

    //     return true;
    // }

public boolean canBeIncreasing(int[] nums) {
    return dfs(nums, 1, nums[0], false);
}

private boolean dfs(int[] nums, int index, int prev, boolean removed) {

    if (index == nums.length)
        return true;

    if (nums[index] > prev) {
        return dfs(nums, index + 1, nums[index], removed);
    }

    if (removed)
        return false;

    // Option 1: remove current
    boolean removeCurrent = dfs(nums, index + 1, prev, true);

    // Option 2: remove previous
    boolean removePrevious = false;

    // Only valid if index == 1 OR nums[index] > nums[index - 2]
    if (index == 1 || nums[index] > nums[index - 2]) {
        removePrevious = dfs(nums, index + 1, nums[index], true);
    }

    return removeCurrent || removePrevious;
}

}