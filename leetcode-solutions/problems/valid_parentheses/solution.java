class Solution {
    public boolean isValid(String str) {
        int s=0,m=0,l=0; char ch;
         Stack<Character> st = new Stack<>();
        for(int i=0;i<str.length();i++){
           
            if (str.charAt(i) == '(')
                st.push(')');
            else if (str.charAt(i) == '{')
                st.push('}');
            else if (str.charAt(i) == '[')
                st.push(']');
            else if (st.empty() || str.charAt(i) != st.pop())
            {
                    return false;
            }
        }
        return st.isEmpty();

    }
}