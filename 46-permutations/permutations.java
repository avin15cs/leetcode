class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        solve(nums,new LinkedHashSet<>(),ans);
        return ans;
    }
    public void solve(int[] nums, Set<Integer> path, List<List<Integer>> res) {
        if(path.size()==nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int num: nums) {
            if(path.add(num)){
                solve(nums,path,res);
                path.remove(num);
            }
        }
    }
}