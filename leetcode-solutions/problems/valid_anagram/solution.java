class Solution {
    // public boolean isAnagram(String s, String t) {
    //     if (s.length() != t.length()) {
    //         return false;
    //     }

    //     HashMap<Character, Integer> sCount = new HashMap<>();
    //     HashMap<Character, Integer> tCount = new HashMap<>();

    //     for (int i = 0; i < s.length(); i++) {
    //         sCount.put(s.charAt(i), 1 + sCount.getOrDefault(s.charAt(i), 0));
    //         tCount.put(t.charAt(i), 1 + tCount.getOrDefault(t.charAt(i), 0));
    //     }

    //     return sCount.equals(tCount);        
    // }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] ch=new int[26];
        for(int i=0;i<s.length();i++) {
            ch[s.charAt(i)-'a']++;
            ch[t.charAt(i)-'a']--;
        }

        for(int i=0;i<26;i++) {
            if(ch[i]!=0)
                return false;
        }

        return true;

    }


    // public boolean isAnagram(String s, String t) {
    //     if (s.length() != t.length()) {
    //         return false;
    //     }

    //     char sc[]=s.toCharArray();
    //     char tc[]=t.toCharArray();
    //     Arrays.sort(sc);
    //     Arrays.sort(tc);

    //     int i=0;
    //     int n=sc.length;
    //     while(i<n && sc[i]==tc[i])
    //         i++;

    //     return i==n;
    // }
}