class Solution {
    public boolean isIsomorphic(String s, String t) {

        //via last index matching
        // int[] smap=new int[256];
        // int[] tmap=new int[256];

        // if(s.length()!=t.length()) return false;

        // for(int i=0;i<s.length();i++){
        //     if(smap[s.charAt(i)]!=tmap[t.charAt(i)]) return false;

        //     smap[s.charAt(i)]=i+1;
        //     tmap[t.charAt(i)]=i+1;
        // }
        // return true;

        Map<Character,Integer> smap=new HashMap<>();
        Map<Character,Integer> tmap=new HashMap<>();

        for(int i=0;i<s.length();i++) {
            char sc=s.charAt(i);
            char tc=t.charAt(i);

            if(!smap.containsKey(sc)) {
                smap.put(sc,i);
            }

            if(!tmap.containsKey(tc)) {
                tmap.put(tc,i);
            }

            if(!tmap.get(tc).equals(smap.get(sc)))
                return false;
        }

        return true;
    }
}