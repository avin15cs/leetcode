class Solution {
    public boolean checkValidString(String st) {
        int max=0;
        int min=0;
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

        return min==0;
    }
}