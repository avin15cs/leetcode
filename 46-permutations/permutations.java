class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new LinkedHashSet<Integer>(), res);
        return res;
    }

    private void backtrack(int[] nums, Set<Integer> cur, List<List<Integer>> res) {
        if(cur.size()==nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if(cur.add(nums[i])) {
                backtrack(nums, cur, res);
                cur.remove(nums[i]);
            }
        }
    }
}