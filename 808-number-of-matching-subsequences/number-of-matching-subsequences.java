class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(String word: words) 
            map.put(word,map.getOrDefault(word, 0)+1);
        int ans = 0;
        char[] ch = s.toCharArray();
        for(String word: map.keySet()) {
            int i=0,j=0;
            int n=word.length();
            char[] c = word.toCharArray();
            while(i<n && j<s.length()) {
                
                if(c[i]==ch[j]) {
                    i++;
                    j++;
                } else {
                    j++;
                }
            }

            if(i==word.length())
                ans+=map.get(word);
        } 

        return ans;  
    }
}