class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;
        int l = 0, r = 0;
        Set<Character> set = new HashSet<>();
        while(r < n)
        {
            char ch = s.charAt(r);
            while(set.contains(ch))
                set.remove(s.charAt(l++));
            set.add(ch);
            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
}