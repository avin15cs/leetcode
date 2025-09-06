class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length()) return false;
        int hashs1[] = new int[26];
        int hashs2[] = new int[26];

        int l=0,r=0;
        while(r<s1.length()) {
            hashs1[s1.charAt(r)-'a']++;
            hashs2[s2.charAt(r)-'a']++;
            r++;
        }
        r--;
        while(r<s2.length()) {
            if(doesMatch(hashs1,hashs2)) return true;

            r++;
            if(r<s2.length())
                hashs2[s2.charAt(r)-'a']++;
            hashs2[s2.charAt(l)-'a']--;
            l++;
        }

        return false;
    }

    private boolean doesMatch(int[] h1, int[] h2) {
        for(int i=0;i<26;i++) {
            if(h1[i]!=h2[i]) return false;
        }

        return true;

    }

}