class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int l1 = s1.length();
        int l2 = s2.length();

        if(l1 > l2)
            return false;

        int[] f1 = new int[26];
        int[] f2 = new int[26];

        int r = 0;
        while(r<l1) {
            f1[s1.charAt(r)-'a']++;
            f2[s2.charAt(r)-'a']++;
            r++;
        }

        r--;

        int l = 0;

        while(r<l2 && r-l+1==l1) {
            if(doesMatch(f1,f2))
                return true;

            f2[s2.charAt(l)-'a']--;
            l++;
            
            r++;
            if(r<l2)
                f2[s2.charAt(r)-'a']++;
        }
        return false;
    }

    boolean doesMatch(int[] f1, int[] f2) {
        for(int i=0;i<26;i++) {
            if(f1[i]!=f2[i])
                return false;
        }

        return true;
    }
}