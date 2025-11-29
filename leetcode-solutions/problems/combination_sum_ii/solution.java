class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
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
            ans.add(candidates[n-1]);
            solve(candidates,target-candidates[n-1],n-1,res,ans);
            ans.remove(ans.size()-1);
        } 

        int currentVal = candidates[n-1];
        int nextN = n - 1;
        
        while (nextN > 0 && candidates[nextN-1] == currentVal) {
            nextN--;
        }

        solve(candidates,target,nextN,res,ans);
    
    }
}