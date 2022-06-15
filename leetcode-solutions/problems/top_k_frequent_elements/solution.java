class Solution {
 
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans=new int[k];
        
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int i:nums)
            map.put(i,map.getOrDefault(i,0)+1);
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> map.get(a)-map.get(b));
        
        for(int j: map.keySet()){
            pq.add(j);
            
            if(pq.size()>k)
                pq.remove();
        }
        
        int idx=0;
        
        while(!pq.isEmpty()){
            ans[idx++]=pq.remove();
        }
        
        return ans;
    }
}