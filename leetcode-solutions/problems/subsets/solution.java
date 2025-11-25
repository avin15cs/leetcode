class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length-1;
        return solve(nums,new ArrayList<>(),n);
    }

    // List<List<Integer>> solve(int[] nums, List<Integer> cur, int n) {
    //     if(n<0) {
    //         List<List<Integer>> ans=new ArrayList<>();
    //         ans.add(new ArrayList<>(cur));
    //         return ans;
    //     }
    //     List<List<Integer>> left = solve(nums,cur,n-1);

    //     List<Integer> newList = new ArrayList<>(cur);
    //     newList.add(nums[n]);

    //     List<List<Integer>> right=solve(nums,newList,n-1);
    //     left.addAll(right);

    //     return left;
    // }

    List<List<Integer>> solve(int[] nums, List<Integer> cur, int n) {
        if(n<0) {
            List<List<Integer>> ans=new ArrayList<>();
            ans.add(new ArrayList<>(cur));
            return ans;
        }
        List<List<Integer>> left = solve(nums,cur,n-1);

        cur.add(nums[n]);

        List<List<Integer>> right=solve(nums,cur,n-1);
        left.addAll(right);
        
        cur.remove(cur.size()-1);

        return left;
    }
}