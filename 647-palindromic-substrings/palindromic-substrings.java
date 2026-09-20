class Solution {
    // int count=0;
    // public int countSubstrings(String s) {
        
    //     for(int i=0;i<s.length();i++) {
    //         expand(s, i, i);//odd
    //         expand(s, i, i+1);//even
    //     }

    //     return count;
    // }

    // private void expand(String s, int left, int right) {
    //     while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
    //         left--;
    //         right++;
    //         count++;
    //     }
    // }


    public int countSubstrings(String s) {

        int count = 0;
        int n=s.length()-1;
        boolean[][] dp = new boolean[n+1][n+1];
        for(int i=n;i>=0;i--) {
            for(int j=i;j<=n;j++) {
                if(s.charAt(i)==s.charAt(j)) {
                    if(j-i<=2) {
                        dp[i][j]=true;
                    } else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }

                if(dp[i][j])
                    count++;
            }
        }

        return count;
    }

}