class Solution {
    public boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;
        s=s.toLowerCase();
        while(i<j){
            char ci=s.charAt(i);
            char cj=s.charAt(j);
            if(!Character.isLetterOrDigit(ci)){
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(cj)){
                j--;
                continue;
            }
            
            if(ci!=cj)
                return false; 
            i++;
            j--;
        }
        return true;
    }
}