class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        
        for(int i=0;i<nums.length; i++){
            if(map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        List<Integer> list = map.get(x);
        if(list != null) {
        for(int i=0;i<queries.length;i++) {
            System.out.println(queries[i]);
            if(queries[i]<=list.size()) {
                ans[i] = list.get(queries[i]-1);
            }
        }
        }
        
        return ans;
    }
}