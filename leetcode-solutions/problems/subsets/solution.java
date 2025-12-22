class Solution {
    // public List<List<Integer>> subsets(int[] nums) {
    //     int n=nums.length-1;
    //     return solve(nums,new ArrayList<>(),n);
    // }

    // List<List<Integer>> solve(int[] nums, List<Integer> cur, int n) {
    //     if(n<0) {
    //         List<List<Integer>> ans=new ArrayList<>();
    //         ans.add(new ArrayList<>(cur));
    //         return ans;
    //     }
    //     List<List<Integer>> left = solve(nums,cur,n-1);

    //     cur.add(nums[n]);

    //     List<List<Integer>> right=solve(nums,cur,n-1);
    //     left.addAll(right);
        
    //     cur.remove(cur.size()-1);

    //     return left;
    // }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        solve(nums,nums.length-1,ans, new ArrayList<>());
        return ans;
    }


    private void solve(int[] nums, int n, List<List<Integer>> ans, List<Integer> list) {
        if(n<0) {
            List<Integer> cur=new ArrayList<>(list);
            ans.add(cur);
            return;
        }

        solve(nums, n-1, ans, list);
        list.add(nums[n]);
        solve(nums, n-1, ans, list);
        list.remove(list.size()-1);
    }
}