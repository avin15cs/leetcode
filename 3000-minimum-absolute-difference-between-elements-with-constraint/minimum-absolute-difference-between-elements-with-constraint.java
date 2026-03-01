class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeSet<Integer> set = new TreeSet<>();
        int ans = Integer.MAX_VALUE;
        for(int i=x;i<nums.size();i++) {
            
            set.add(nums.get(i-x));
            int cur = nums.get(i);

            Integer floor = set.floor(cur);

            if(floor!=null) 
                ans = Math.min(ans, Math.abs(floor-cur));

            Integer ceil = set.ceiling(cur);
            
            if(ceil!=null)
                ans = Math.min(ans, Math.abs(ceil-cur));
        }

        return ans;
    }
}