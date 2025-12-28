class Solution {
    // public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    //     List<List<Integer>> res=new ArrayList<>();
    //     Arrays.sort(candidates);
    //     solve(candidates,target,candidates.length, res, new ArrayList<>());

    //     return res;
    // }

    // public void solve(int[] candidates, int target, int n, List<List<Integer>> res, List<Integer> ans)  {
    //     if(target==0) {
    //         List<Integer> list = new ArrayList<>(ans);
    //         res.add(list);
    //         return;
    //     }
    //     if(n<=0||target<=0) {
    //         return;
    //     }

    //     if(candidates[n-1]<=target) {
    //         ans.add(candidates[n-1]);
    //         solve(candidates,target-candidates[n-1],n-1,res,ans);
    //         ans.remove(ans.size()-1);
    //     }

    //     int curpos=n-1;
    //     int curval=candidates[n-1];
    //     while(curpos>0 && curval==candidates[curpos-1])
    //         curpos--;

    //     solve(candidates,target,curpos,res,ans);
    
    // }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,0,target,res, new ArrayList<>());
        return res;
    }

    void backtrack(int[] candidates, int start, int target, List<List<Integer>> res, List<Integer> ans) {
        if(target==0) {
            List<Integer> list=new ArrayList<>(ans);
            res.add(list);
            return;
        }

        for(int i=start;i<candidates.length;i++) {
            if(i>start && candidates[i]==candidates[i-1])
                continue;
            
            if(candidates[i]<=target) {
                ans.add(candidates[i]);
                backtrack(candidates,i+1,target-candidates[i],res,ans);
                ans.remove(ans.size()-1);
            }
        }
    }
}