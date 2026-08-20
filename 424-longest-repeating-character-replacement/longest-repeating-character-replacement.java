class Solution {
    public int characterReplacement(String s, int k) {
        int[] f= new int[26];
        int i=0,j=0,n=s.length();
        int maxFreq=0;
        int ans=0;
        while(j<n) {
            int idx = s.charAt(j)-'A';
            f[idx]++;
            maxFreq = Math.max(maxFreq, f[idx]);

            while((j-i+1)-maxFreq>k) {
                f[s.charAt(i)-'A']--;
                i++;
            }

            ans = Math.max(ans, j-i+1);
            j++;
        }

        return ans;

    }
}