class Solution {
    public boolean isPalindrome(String s) {
        String st=s.toLowerCase();

        int i=0,j=st.length()-1;

        while(i<j) {
            while(i<j && !Character.isLetterOrDigit(st.charAt(i)))
                i++;

            while(i<j && !Character.isLetterOrDigit(st.charAt(j)))
                j--;
            
            if(st.charAt(i)!=st.charAt(j))
                return false;
            
            i++;
            j--;
        }

        return true;
    }
}