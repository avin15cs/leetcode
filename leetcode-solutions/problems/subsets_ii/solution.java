class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        return solve(nums, new ArrayList<>(), n-1);
    }

    List<List<Integer>> solve(int[] nums, List<Integer> cur, int n) {
        if(n<0) {
            List<List<Integer>> ans=new ArrayList<>();
            ans.add(new ArrayList<>(cur));
            return ans;
        }

        int next=n-1;
        while(next>=0 && nums[n]==nums[next]){
            next--;
        }

        List<List<Integer>> left=solve(nums,cur,next);

        cur.add(nums[n]);
        List<List<Integer>> right=solve(nums,cur,n-1);
        cur.remove(cur.size()-1);
        left.addAll(right);

        return left;
    }
}