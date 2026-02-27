class Solution {
    public int firstUniqChar(String s) {
        // for(int i=0;i<s.length();i++) {
        //     char c=s.charAt(i);
        //     if(s.indexOf(c)==s.lastIndexOf(c))
        //         return i;
        // }

        // return -1;

        int array[] = new int[26];

        for(int i = 0; i < s.length(); i++)
            array[s.charAt(i) - 'a'] += 1;

        for(int i = 0; i < s.length(); i++)
            if(array[s.charAt(i) - 'a'] == 1)
                return i;

        return -1;
    }
}