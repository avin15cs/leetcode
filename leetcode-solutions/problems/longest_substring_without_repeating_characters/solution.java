class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        
        int i=0,j=0,n=s.length();
        int maxl=0;
        
        while(j<n){
            char c=s.charAt(j);
            while(set.contains(c)) {
                set.remove(s.charAt(i++));
            } 
            set.add(c);
            maxl=Math.max(maxl,set.size()); 
            j++;  
        }
        
        return maxl;
    }
}