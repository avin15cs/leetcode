class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        solve(candidates,target,candidates.length, res, new ArrayList<>());

        return res;
    }

    public void solve(int[] candidates, int target, int n, List<List<Integer>> res, List<Integer> ans)  {
        if(target==0) {
            List<Integer> list = new ArrayList<>(ans);
            res.add(list);
            return;
        }
        if(n<=0||target<=0) {
            return;
        }

        if(candidates[n-1]<=target) {
            solve(candidates,target,n-1,res,ans);
            ans.add(candidates[n-1]);
            solve(candidates,target-candidates[n-1],n,res,ans);
            ans.remove(ans.size()-1);
        } else {
            solve(candidates,target,n-1,res,ans);
        }

    }
}