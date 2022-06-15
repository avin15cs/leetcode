class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         Arrays.sort(nums);
//         int n=nums.length;
        
//         for(int i=1;i<n;i++){
//             if(nums[i-1]==nums[i])
//                 return true;
//         }
        
//         return false;
//     }
    
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        
        for(int i:nums){
            if(set.contains(i))
                return true;
            
            set.add(i);
        }
        
        return false;
    }
}