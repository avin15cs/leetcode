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
        int ls = s.length();
        int lt = t.length();

        Map<Character, Integer> tmap = new HashMap<>();

        for(int i=0;i<lt;i++) {
            char c = t.charAt(i);
            tmap.put(c,tmap.getOrDefault(c, 0)+1);
        }

        Map<Character, Integer> smap = new HashMap<>();

        int i=0, j=0, min=Integer.MAX_VALUE;
        int tsize = tmap.size(), size = 0;
        int start = 0;
        while(j<ls) {
            char c = s.charAt(j);
            smap.put(c, smap.getOrDefault(c,0)+1);
            if(tmap.containsKey(c) && smap.get(c).intValue()==tmap.get(c).intValue())
                size++;

            while(size == tsize) {
                if(min>j-i+1) {
                    min = j-i+1;
                    start = i;
                }
                char ch = s.charAt(i);
                smap.put(ch, smap.get(ch)-1);
                i++;
                if(tmap.containsKey(ch) && tmap.get(ch)>smap.get(ch))
                    size--;
            }
            j++;
        }

        return (min==Integer.MAX_VALUE)?"":s.substring(start, start+min);
    }
}