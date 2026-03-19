class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if(hand.length%groupSize!=0)
            return false;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i: hand)
            map.put(i, map.getOrDefault(i,0)+1);

        Arrays.sort(hand);
        for(int n: hand) {
            if(map.get(n)==0)
                continue;

            for(int i=n;i<n+groupSize;i++) {
                if(map.getOrDefault(i,0)==0)
                    return false;

                map.put(i, map.get(i)-1);
            }
        }

        return true;
    }
}