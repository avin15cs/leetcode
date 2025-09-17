class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        StringBuilder cp=new StringBuilder();
        int n=strs.length;
        int l0=strs[0].length();
        int ln=strs[n-1].length();
        int i=0,j=0;
        while(i<l0 && j<ln){
            if(strs[0].charAt(i)!=strs[n-1].charAt(j))
                break;
            cp.append(strs[0].charAt(i));

            i++;
            j++;
        }

        return cp.toString();
    }
}