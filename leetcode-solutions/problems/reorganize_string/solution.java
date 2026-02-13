class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c: s.toCharArray())
            map.put(c, map.getOrDefault(c,0)+1);
        
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));

        pq.addAll(map.keySet());

        if (map.get(pq.peek()) > (s.length() + 1) / 2)
            return "";

        StringBuilder sb = new StringBuilder();

        Character prev = null;

        while(!pq.isEmpty()) {
            char cur = pq.remove();
            map.put(cur, map.get(cur)-1);
            sb.append(cur);

            if(prev!=null && map.get(prev)>0)
                pq.add(prev);

            prev = cur;
        }

        return sb.toString();
    }
}