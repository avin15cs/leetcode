class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for(int i: arr)
            map.put(i, map.getOrDefault(i,0)+1);

        PriorityQueue<Integer> minH = new PriorityQueue<>();

        for(int i: map.values())
            minH.add(i);

        int i=0;
        while(!minH.isEmpty() && k>=minH.peek())
            k-=minH.remove();
        

        return minH.size();
    }
}