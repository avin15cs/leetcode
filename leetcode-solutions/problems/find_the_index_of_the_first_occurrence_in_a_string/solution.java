class Solution {
    public int strStr(String haystack, String needle) {
        // int ln=needle.length();
        // int lh=haystack.length();

        // for(int i=0;i<=lh-ln;i++){

        //     if(haystack.substring(i,i+ln).equals(needle))
        //         return i;
                
        // }

        // return -1;

        int ln=needle.length();
        int lh=haystack.length();

        for(int i=0;i<=lh-ln;i++){

            int j=0;
            while(j<ln && needle.charAt(j)==haystack.charAt(i+j)){
                j++;
            }
            if(j==ln) 
                return i;
        }

        return -1;
    }
}