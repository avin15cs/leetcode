class Solution {
    public int longestConsecutive(int[] nums) {
        // if(nums.length==0) return 0;
        // Set<Integer> set=new HashSet<>();

        // for(int num: nums)
        //     set.add(num);

        // int maxCount=1;
        // for(int num: nums) {
        //     if(!set.contains(num-1)){
        //         int count=1;
        //         int tnum=num;
        //         while(set.contains(tnum+1)) {
        //             count++;
        //             tnum++;
        //         }
        //         maxCount=Math.max(maxCount,count);
        //     }
        // }
        // return maxCount;

        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : nums) {
            int prev=num-1,next=num+1;
            int currentStreak = 1;
            while(set.contains(prev)){
                set.remove(prev--);
                currentStreak++;
            }
                
            while (set.contains(next)) {
                set.remove(next++);
                currentStreak++;
            }
            longest = Math.max(longest, currentStreak);
            
        }

        return longest;
    }
}