class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        solve(nums,new LinkedHashSet<>(),list);
        return list;
    }

    private void solve(int[] nums,Set<Integer> set,List<List<Integer>> list) {
        if(set.size()==nums.length) {
            List<Integer> ans=new ArrayList<>(set);
            list.add(ans);
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if(set.add(nums[i])) {
                solve(nums,set,list);
                set.remove(nums[i]);
            }
        }
    }
}