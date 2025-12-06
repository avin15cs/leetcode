class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();

        if(m>n)
            return "";

        HashMap<Character,Integer> smap=new HashMap<>();
        HashMap<Character,Integer> tmap=new HashMap<>();

        for(char c:t.toCharArray()) {
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }

        int size=tmap.size();
        int reqSize=0;
        int i=0,j=0;
        int min=Integer.MAX_VALUE;
        int start=i;
        while(j<n) {
            char c=s.charAt(j);
            smap.put(c,smap.getOrDefault(c,0)+1);

            if(tmap.containsKey(c) && tmap.get(c).intValue()==smap.get(c).intValue())
                reqSize++;

            while(size==reqSize) {

                if(min>j-i+1) {
                    min=j-i+1;
                    start=i;
                }
                char ch=s.charAt(i);
                smap.put(ch,smap.get(ch)-1);
                
                if(tmap.containsKey(ch) && tmap.get(ch)>smap.get(ch))
                    reqSize--;
                i++;
            }
            j++;
        }
        return min==Integer.MAX_VALUE?"":s.substring(start,start+min);
    }
}