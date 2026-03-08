class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        solve(nums,new ArrayList<>(),ans);
        return ans;
    }
    public void solve(int[] nums, List<Integer> path, List<List<Integer>> res) {
        if(path.size()==nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int num: nums) {
            if(!path.contains(num)){
                path.add(num);
                solve(nums,path,res);
                path.remove(path.size()-1);
            }
        }
    }
}