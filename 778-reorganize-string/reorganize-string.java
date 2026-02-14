class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        pq.addAll(map.keySet());
        
        if(map.get(pq.peek())>(s.length()+1/2))
            return "";

        StringBuilder sb = new StringBuilder();
        Character prev = null;
        while(!pq.isEmpty()) {
            char c = pq.remove();
            sb.append(c);
            map.put(c, map.get(c)-1);

            if(prev!=null && map.get(prev)>0) {
                pq.add(prev);
            }
            prev = c;
        }

        return s.length()==sb.length()?sb.toString():"";
    }
}