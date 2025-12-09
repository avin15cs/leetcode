class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i: nums) {
            map.put(i, map.getOrDefault(i,0)+1);
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        pq.addAll(map.keySet());

        int[] ans=new int[k];

        for(int i=0;i<k;i++)
            ans[i]=pq.remove();

        return ans;
        // Map<Integer, Integer> freqMap = new HashMap<>();
        // for (int n : nums) {
        //     freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        // }

        // // Create List of Lists
        // List<List<Integer>> bucket = new ArrayList<>();
        // for (int i = 0; i <= nums.length; i++) {
        //     bucket.add(new ArrayList<>());
        // }

        // // Fill buckets
        // for (int key : freqMap.keySet()) {
        //     int freq = freqMap.get(key);
        //     bucket.get(freq).add(key);
        // }

        // // Collect results
        // List<Integer> res = new ArrayList<>();
        // for (int pos = bucket.size() - 1; pos >= 0 && res.size() < k; pos--) {
        //     if (!bucket.get(pos).isEmpty()) {
        //         res.addAll(bucket.get(pos));
        //     }
        // }
        // return res.stream().mapToInt(Integer::intValue).toArray();
    }
}