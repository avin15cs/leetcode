class Solution {
    // public String longestCommonPrefix(String[] strs) {
    //     Arrays.sort(strs);

    //     StringBuilder cp=new StringBuilder();
    //     int n=strs.length;
    //     int l0=strs[0].length();
    //     int ln=strs[n-1].length();
    //     int i=0,j=0;
    //     while(i<l0 && j<ln){
    //         if(strs[0].charAt(i)!=strs[n-1].charAt(j))
    //             break;
    //         cp.append(strs[0].charAt(i));

    //         i++;
    //         j++;
    //     }

    //     return cp.toString();
    // }

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

}