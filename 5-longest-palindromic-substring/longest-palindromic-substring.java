class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n<2) return s;
        int maxLen = 1;
        int start = 0;
        for(int i=0;i<n;i++)
        {
            int odd = expand(s, i, i);
            int even = expand(s, i, i+1);
            int len = Math.max(odd, even);
            if(len > maxLen)
            {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    public int expand(String s, int i, int j)
    {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j))
        {
            i--;
            j++;
        }
        return j-i-1;
    }
}