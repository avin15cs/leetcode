class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);

        int longest = 0;

        for(int num : set){
            // start only if num is beginning of sequence
            if(!set.contains(num - 1)){
                int current = num;
                int streak = 1;
                while(set.contains(current + 1)){
                    current++;
                    streak++;
                }
                longest = Math.max(longest, streak);
            }
        }
        return longest;
        
        // if (nums.length == 0) return 0;

        // Set<Integer> set = new HashSet<>();
        // for (int num : nums) {
        //     set.add(num);
        // }

        // int longest = 0;

        // for (int num : nums) {
        //     int prev=num-1,next=num+1;
        //     int currentStreak = 1;
        //     while(set.contains(prev)){
        //         set.remove(prev--);
        //         currentStreak++;
        //     }
                
        //     while (set.contains(next)) {
        //         set.remove(next++);
        //         currentStreak++;
        //     }
        //     longest = Math.max(longest, currentStreak);
            
        // }

        // return longest;
    }
}