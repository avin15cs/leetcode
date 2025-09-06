class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> list = new ArrayList<>();
        if(p.length()>s.length()) return list;
        int l=0,r=0;
        int hashs[]=new int[26];
        int hashp[]=new int[26];

        for(int i =0;i<p.length();i++) 
            hashp[p.charAt(i)-'a']++;

        while(r<s.length()) {
            hashs[s.charAt(r)-'a']++;
            
            if(r-l+1==p.length()){
                if(doesMatch(hashs,hashp)) 
                    list.add(l);
                
                hashs[s.charAt(l)-'a']--;
                l++;
            }
            r++;

        } 
        return list;
    }
    public boolean doesMatch(int[] hs, int[] hp)
    {
        for(int i=0;i<26;i++)
        {
            if(hs[i] != hp[i])
                return false;
        }
        return true;
    }
}