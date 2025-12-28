class Solution {
    // public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     List<List<Integer>> res=new ArrayList<>();
    //     solve(candidates,target,candidates.length, res, new ArrayList<>());

    //     return res;
    // }

    // void solve(int[] nums, int sum, int n, List<List<Integer>> res, List<Integer> ans) {
    //     if(sum==0) {
    //         List<Integer> list=new ArrayList<>(ans);
    //         res.add(list);
    //         return;
    //     }

    //     if(n<=0||sum<=0) {
    //         return;
    //     }

    //     if(nums[n-1]<=sum) {
    //         ans.add(nums[n-1]);
    //         solve(nums,sum-nums[n-1],n,res,ans);
    //         ans.remove(ans.size()-1);
    //     }
    //     solve(nums,sum,n-1,res,ans);
    // }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] arr, int start, int target, List<Integer> curr, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        if(target < 0) return;

        for(int i = start; i < arr.length; i++) {
            if (arr[i] > target) continue;
            curr.add(arr[i]);  // include arr[i]
            backtrack(arr, i, target - arr[i], curr, res); // i not i+1 → reuse allowed
            curr.remove(curr.size() - 1); // backtrack
        }
    }
}