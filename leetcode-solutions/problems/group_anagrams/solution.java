class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String s: strs) {
            int[] count = new int[26];
            for(char c: s.toCharArray()){
                count[c-'a']++;
            }

            StringBuilder sb=new StringBuilder();
            for(int n: count)
                sb.append(n).append("_");
            
            String key=sb.toString();
            System.out.println(key);
            if(!map.containsKey(sb.toString()))
                map.put(key, new ArrayList<>());
            
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}