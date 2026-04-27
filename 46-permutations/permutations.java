class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        solve(nums,new LinkedHashSet<>(),ans,used);
        return ans;
    }
    public void solve(int[] nums, Set<Integer> path, List<List<Integer>> res, boolean[] used) {
        if(path.size()==nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if(used[i]) continue;

            path.add(nums[i]);
            used[i]=true;
            solve(nums,path,res,used);
            used[i]=false;
            path.remove(nums[i]);
        }
    }
}