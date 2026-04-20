class Solution {
    public int longestSubstring(String s, int k) {
        return solve(s,0,s.length(),k);
    }

    private int solve(String s, int start, int end, int k) {
        if(end-start<k)
            return 0;

        int[] fq=new int[26];

        for(int i=start;i<end;i++)
            fq[s.charAt(i)-'a']++;

        for(int i=start;i<end;i++) {
            if(fq[s.charAt(i)-'a']<k) {
                int next = i+1;

                while(next<end && fq[s.charAt(next)-'a']<k)
                    next++;

                return Math.max(solve(s,start,i,k),solve(s,next,end,k));
            }
        }

        return end-start;
    }
}