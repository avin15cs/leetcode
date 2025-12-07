class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        int write=0;
        for(int i=0;i<n;) {
            char c=chars[i];
            int count=0;
            while(i<n &&chars[i]==c) {
                count++;
                i++;
            }
            chars[write++]=c;

            if(count>1) {
                for(char ch: String.valueOf(count).toCharArray())
                    chars[write++]=ch;
            }
        }

        return write;
    }
}