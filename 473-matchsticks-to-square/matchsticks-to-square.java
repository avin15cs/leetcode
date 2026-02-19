class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks==null || matchsticks.length<4)
            return false;
        int sum = 0;
        for(int match:matchsticks)
            sum+=match;

        if(sum%4!=0)
            return false;

        int target = sum/4;
        Arrays.sort(matchsticks);
        int n = matchsticks.length;
        int[] sides = new int[4];
        return dfs(matchsticks, sides, n-1, target);
    }

    boolean dfs(int[] nums, int[] sides, int idx, int target) {
        if(idx<0) {
            return sides[0]==target &&
            sides[1]==target &&
            sides[2]==target &&
            sides[3]==target;
        }

        int cur = nums[idx];
        for(int i=0;i<4;i++) {
            if(cur+sides[i]>target)
                continue;

            sides[i]+=cur;
    
            if(dfs(nums, sides, idx-1,target))
                return true;

            sides[i]-=cur;

            if(sides[i]==0)
                break;
        }

        return false;
    }


}