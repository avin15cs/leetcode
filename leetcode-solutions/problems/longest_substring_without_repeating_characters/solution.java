class Solution {
    // public int lengthOfLongestSubstring(String s) {
    //     Set<Character> set=new HashSet<>();
        
    //     int i=0,j=0,n=s.length();
    //     int maxl=0;
        
    //     while(j<n) {
    //         char c=s.charAt(j);
            
    //         if(!set.contains(c)) {
    //             set.add(c);
    //             maxl=Math.max(maxl,set.size());
    //             j++;   
    //         }
    //         else
    //             set.remove(s.charAt(i++));
    //     }
        
    //     return maxl;
    // }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int maxl=0,i=0,j=0,n=s.length();
        while(j<n) {
            char c = s.charAt(j);

            if(set.add(c)) {
                maxl = Math.max(maxl, set.size());
                j++;
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return maxl;
    }
}