class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map= new HashMap<>();

        for(int i=0;i<nums.length; i++) {
            // List<Integer> list=new ArrayList<>();
            
            if(!map.containsKey(nums[i])) {
                map.put(nums[i],i);
            } else {
                int diff=Math.abs(map.get(nums[i])-i);
                if(diff<=k) return true;

                map.put(nums[i],i);
            }
        }

        return false;

    }
}