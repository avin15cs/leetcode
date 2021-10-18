class Solution {
    public int removeDuplicates(int[] nums) {
//         HashSet<Integer> has = new HashSet<>();
        
//         for( int i =0; i<nums.length;i++) {
//             has.add(nums[i]);
//         }
        
//         return has.size();
        
        int j=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=nums[j])
            {
                j++;
                nums[j]=nums[i];
            }
        }
        return ++j;
    }
}