class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int prefixSum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int count=0;
        for(int i=0;i<n;i++) {
            prefixSum+=nums[i];

            int val = prefixSum-k;
            if(map.get(val)!=null) {
                count+=map.get(val);
            }

            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }

        return count;
    }
}