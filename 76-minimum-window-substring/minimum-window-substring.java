class Solution {
    // public String minWindow(String s, String t) {
    // int sl = s.length();
    // int tl = t.length();
    // if (sl < tl) return "";

    // int i = 0, j = 0;

    // Map<Character, Integer> tmap = new HashMap<>();
    // for (int k = 0; k < tl; k++) {
    //     char c = t.charAt(k);
    //     tmap.put(c, tmap.getOrDefault(c, 0) + 1);
    // }

    // int size = tmap.size();  // number of unique chars needed
    // Map<Character, Integer> smap = new HashMap<>();
    // int reqSize = 0;

    // int minSize = Integer.MAX_VALUE;
    // int start = 0;

    // while (j < sl) {

    //     char c = s.charAt(j);

    //     // INSERT ALWAYS
    //     smap.put(c, smap.getOrDefault(c, 0) + 1);

    //     // MATCH ONLY IF RELEVANT
    //     if (tmap.containsKey(c) &&
    //         smap.get(c).intValue() == tmap.get(c).intValue()) {
    //         reqSize++;
    //     }

    //     // SHRINK
    //     while (reqSize == size) {

    //         if (j - i + 1 < minSize) {
    //             minSize = j - i + 1;
    //             start = i;
    //         }

    //         char ci = s.charAt(i);

    //         // REMOVE ALWAYS
    //         smap.put(ci, smap.get(ci) - 1);

    //         // BREAK MATCH ONLY IF RELEVANT
    //         if (tmap.containsKey(ci) &&
    //             smap.get(ci) < tmap.get(ci)) {
    //             reqSize--;
    //         }

    //         i++;
    //     }

    //     j++;
    // }

    // return minSize == Integer.MAX_VALUE
    //         ? ""
    //         : s.substring(start, start + minSize);
    // }

    public String minWindow(String s, String t) {
        int sl = s.length();
        int tl = t.length();

        if(tl>sl) return "";

        Map<Character, Integer> tmap = new HashMap<>();
        for(int i=0;i<tl;i++) {
            char c = t.charAt(i);
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }

        int size = tmap.size();
        Map<Character, Integer> smap = new HashMap<>();

        int i=0,j=0, reqSize = 0, minSize = Integer.MAX_VALUE, start=0;

        while(j<sl) {
            char c = s.charAt(j);
            smap.put(c, smap.getOrDefault(c,0)+1);

            if(tmap.containsKey(c) && tmap.get(c).intValue()==smap.get(c).intValue())
                reqSize++;

            while(size == reqSize) {

                if(minSize>j-i+1) {
                    minSize = j-i+1;
                    start = i;
                }

                char ci = s.charAt(i);
                smap.put(ci, smap.get(ci)-1);

                if(tmap.containsKey(ci)&&smap.get(ci)<tmap.get(ci))
                    reqSize--;

                i++;
            }
            j++;
        }

        return minSize==Integer.MAX_VALUE?"":s.substring(start,start+minSize);
    }
}