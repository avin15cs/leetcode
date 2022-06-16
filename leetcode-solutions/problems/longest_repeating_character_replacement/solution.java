class Solution {
    public int characterReplacement(String s, int k) {
        int i=0,j=0,n=s.length();
        
        int maxWindow=0,maxRepeat=0;
        Map<Character,Integer> map=new HashMap<>();
        
        while(j<n){
            char c=s.charAt(j);
            map.put(c, map.getOrDefault(c,0)+1);
            
            maxRepeat=Math.max(maxRepeat,map.get(c));
            
            if(j-i+1-maxRepeat>k){
                char remove=s.charAt(i);
                map.put(remove,map.get(remove)-1);
                i++;
            }
            
            maxWindow=Math.max(maxWindow,j-i+1);
            j++;
            
        }
        
        return maxWindow;
    }
}