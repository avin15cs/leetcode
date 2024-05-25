class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        int ans = 0;
        
        if(map.size() == nums.length) return 0;
        
        
        else {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getValue()==2) {
                 ans=ans ^ entry.getKey();
                }
            }
        }
        
        return ans;
        
    }
}