class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        
        Map<String, Integer> map = new HashMap<>();
        int[] count = new int[26];

        int distinct = 0;
        int left = 0, right = 0;
        int ans = 0;
        while(right<s.length()) {
            char c = s.charAt(right);
            
            if(count[c-'a']++==0)
                distinct++;

            if(right-left+1 == minSize) {
                if(distinct<=maxLetters) {
                    String sub = s.substring(left,right+1);
                    int freq = map.getOrDefault(sub,0)+1;
                    map.put(sub,freq);
                    ans = Math.max(ans, freq);
                }
                
                if(--count[s.charAt(left)-'a']==0)
                    distinct--;
                
                left++;   
            }

            right++;
        }

        return ans;

    }
}