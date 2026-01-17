class Solution {
    public boolean checkValidString(String st) {

        //this is range of open bracket. 
        int max=0; //max no of open brackets 
        int min=0; //min no of open brackets
        for(char c: st.toCharArray()) {
            if(c=='(') {
                max++;
                min++;
            } else if(c==')') {
                max--;
                min--;
            } else {
                max++;
                min--;
            }

            if(min<0)
                min=0;
            
            if(max<0)
                return false;
        }

        return min==0 ;
    }
}