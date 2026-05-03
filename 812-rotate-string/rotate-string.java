class Solution {
    // public boolean rotateString(String s, String goal) {
        
    //     if(s.length()!=goal.length())
    //         return false;

    //     for(int i=0;i<s.length();i++) {
    //         if(s.charAt(i)==goal.charAt(0) && isEqual(s, goal, i))
    //             return true;
    //     }

    //     return false;
    // }

    // boolean isEqual(String s, String goal, int idx) {

    //     StringBuilder sb = new StringBuilder(s.substring(idx));
    //     sb.append(s.substring(0,idx));

    //     if(sb.toString().equals(goal))
    //         return true;

    //     return false;
    // }   

    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        
        s= s+s;

        
        if(s.indexOf(goal) != -1) return true;
        
        return false;

    }
}