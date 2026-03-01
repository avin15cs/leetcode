import java.util.*;

class Solution {
    public int findMinDifference(List<String> timePoints) {

        List<Integer> minutes = new ArrayList<>();

        // Step 1: Convert to minutes
        for (String time : timePoints) {
            String[] parts = time.split(":");
            int hour = Integer.parseInt(parts[0]);
            int min = Integer.parseInt(parts[1]);
            minutes.add(hour * 60 + min);
        }

        // Step 2: Sort
        Collections.sort(minutes);

        int ans = Integer.MAX_VALUE;

        // Step 3: Compare adjacent
        for (int i = 1; i < minutes.size(); i++) {
            ans = Math.min(ans, minutes.get(i) - minutes.get(i - 1));
        }

        // Step 4: Circular difference
        int circularDiff = 1440 - minutes.get(minutes.size() - 1) + minutes.get(0);
        ans = Math.min(ans, circularDiff);

        return ans;
    }
}