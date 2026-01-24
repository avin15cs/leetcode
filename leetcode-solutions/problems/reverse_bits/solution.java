class Solution {
    public int reverseBits(int n) {
        int rev=0;
        for(int i=1;i<=32;i++) {
            int mask = n&1;
            rev = rev<<1;

            if(mask==1)
                rev=rev|1;

            n=n>>1;
        }

        return rev;
        // return Integer.reverse(n);
    }
}