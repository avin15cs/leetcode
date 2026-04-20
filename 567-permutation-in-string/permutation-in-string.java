class Solution {
    public boolean checkInclusion(String p, String s) {
        
        // int l1 = s1.length();
        // int l2 = s2.length();

        // if(l1 > l2)
        //     return false;

        // int[] f1 = new int[26];
        // int[] f2 = new int[26];

        // int r = 0;
        // while(r<l1) {
        //     f1[s1.charAt(r)-'a']++;
        //     f2[s2.charAt(r)-'a']++;
        //     r++;
        // }

        // r--;

        // int l = 0;

        // while(r<l2 && r-l+1==l1) {
        //     if(doesMatch(f1,f2))
        //         return true;

        //     f2[s2.charAt(l)-'a']--;
        //     l++;
            
        //     r++;
        //     if(r<l2)
        //         f2[s2.charAt(r)-'a']++;
        // }
        // return false;

        if(p.length()>s.length()) return false;
        int l=0,r=0;
        int hashs[]=new int[26];
        int hashp[]=new int[26];

        for(int i =0;i<p.length();i++) 
            hashp[p.charAt(i)-'a']++;

        int n = p.length();
        while(r<s.length()) {
            hashs[s.charAt(r)-'a']++;
            
            if(r-l+1==n){
                if(doesMatch(hashs,hashp)) 
                    return true;
                
                hashs[s.charAt(l)-'a']--;
                l++;
            }
            r++;

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