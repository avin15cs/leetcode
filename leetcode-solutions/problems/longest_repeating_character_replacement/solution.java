class Solution {
    public int characterReplacement(String s, int k) {
        int maxRepeat = 0, ans = 0;
        int j=0,i=0;
        int[] f = new int[26];
        while(j<s.length()) {
            int idx = s.charAt(j) - 'A';
            f[idx]++;
            maxRepeat = Math.max(maxRepeat, f[idx]);
            if(j-i+1-maxRepeat>k) {
                f[s.charAt(i)-'A']--;
                i++;
            }

            ans = Math.max(ans, j-i+1);
            j++;
        }

        return ans;
    }
}