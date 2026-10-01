class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        StringBuilder sb = new StringBuilder();
        int i=0, write=0;
        while(i<n) {
            char c = chars[i];
            int count=0;
            while(i<n && c==chars[i]) {
                count++;
                i++;
            }
            
            chars[write++]=c;

            if(count>1) {
                String no = String.valueOf(count);

                for(int j=0;j<no.length();j++)
                    chars[write++]=no.charAt(j);
            }
        
        }

        return write;
    }
}