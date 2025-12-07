class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();

        if(n<2) return s;
        int maxLen=1;
        int start=0;
        for(int center=0;center<n;center++) {
            int oddExpand=expand(s,center,center);

            int evenExpand=expand(s,center,center+1);

            int len=Math.max(oddExpand,evenExpand);

            if(maxLen<len) {
                maxLen=len;
                start=center-(len-1)/2;
            }
        }
        return s.substring(start,start+maxLen);
    }

    private int expand(String s, int left, int right) {
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
            left--;
            right++;
        }
        //already moved out of ans inside while loop as it breaks at that point
        //return right-1-(left+1)+1 => actual answer;
        // turns out to be right - left -1
        return right-left-1;
    }

}