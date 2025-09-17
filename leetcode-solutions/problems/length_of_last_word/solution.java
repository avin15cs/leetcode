class Solution {
    public int lengthOfLastWord(String s) {
        // String[] s=str.split(" ");
        // return s[s.length-1].length();

        s=s.trim();
        int length=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' ')
                length++;
            
            else
                break;
        }
        return length;
    }
}