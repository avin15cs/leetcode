class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int i=0,n=s.length();

        if(n%2!=0)
            return false;

        while(i<n) {
            char c = s.charAt(i);

            if(c=='(') 
                st.push(')');
            
            else if(c=='{') 
                st.push('}');
            
            else if(c=='[') 
                st.push(']');
            
            else {
                if(st.isEmpty())
                    return false;
                    
                if(!st.isEmpty() && st.pop()!=c)
                    return false;
            }

            i++;
        }

        return st.isEmpty();
    }
}