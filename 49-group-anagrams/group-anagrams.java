class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        
        for(String str: strs){
            
            char[] c=str.toCharArray();
            Arrays.sort(c);
            String key=new String(c);
            
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            
            List<String> list=map.get(key);
            list.add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}