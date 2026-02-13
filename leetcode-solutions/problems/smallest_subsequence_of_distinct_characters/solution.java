class Solution {

    /**
    This problem is a combination of:
    Greedy choice property
    Monotonic increasing stack
    Last occurrence tracking
    Visited marking
     */
    public String smallestSubsequence(String s) {
        int[] last = new int[26];
        int n=s.length();
        //last position of each character is added here
        for(int i=0;i<n;i++)
            last[s.charAt(i)-'a']=i;

        boolean[] seen = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<n;i++) {
            char c = s.charAt(i);

            if(seen[c-'a'])
                continue;

            while(!stack.isEmpty() && stack.peek()>c && last[stack.peek()-'a']>i)
                seen[stack.pop()-'a']=false;
            
            stack.push(c);
            seen[c-'a']=true;
        }

        StringBuilder sb = new StringBuilder();
        for(char c: stack)
            sb.append(c);

        return sb.toString();

    }
}