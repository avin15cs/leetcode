class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length()!=words.length) 
            return false;
        
        Map<Character,String> cmap=new HashMap<>();
        Map<String,Character> smap=new HashMap<>();

        for(int i=0;i<words.length;i++) {
            char c=pattern.charAt(i);
            if(!cmap.containsKey(c))
                cmap.put(c,words[i]);
            
            if(!smap.containsKey(words[i]))
                smap.put(words[i],c);
            
            if(!cmap.get(c).equals(words[i])||!smap.get(words[i]).equals(c))
                return false;
        }

        return true;
    }
}