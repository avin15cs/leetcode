class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0,j=0,n=s.length(),m=t.length();
        while(i<n && j<m){
            if(j<m && s.charAt(i)!=t.charAt(j))
                j++;
            else {
                i++;
                j++;
            }
        }
        return i==n;
    }
}