class Solution {
    // public List<List<Integer>> subsetsWithDup(int[] nums) {
    //     int n=nums.length;
    //     Arrays.sort(nums);
    //     return solve(nums, new ArrayList<>(), n-1);
    // }

    // List<List<Integer>> solve(int[] nums, List<Integer> cur, int n) {
    //     if(n<0) {
    //         List<List<Integer>> ans=new ArrayList<>();
    //         ans.add(new ArrayList<>(cur));
    //         return ans;
    //     }

    //     int next=n-1;
    //     while(next>=0 && nums[n]==nums[next]){
    //         next--;
    //     }

    //     List<List<Integer>> left=solve(nums,cur,next);

    //     cur.add(nums[n]);
    //     List<List<Integer>> right=solve(nums,cur,n-1);
    //     cur.remove(cur.size()-1);
    //     left.addAll(right);

    //     return left;
    // }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    void backtrack(List<List<Integer>> res, List<Integer> cur, int[] nums, int idx) {
        res.add(new ArrayList<>(cur));

        for(int i=idx;i<nums.length;i++) {
            if(i>idx && nums[i]==nums[i-1])
                continue;

            cur.add(nums[i]);
            backtrack(res, cur, nums, i+1);
            cur.remove(cur.size()-1);
        }
    }
}