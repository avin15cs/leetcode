public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rev=0,mask;
        for(int i=0;i<32;i++) {
            mask=n&1;
            rev=rev<<1;
            if(mask==1)
                rev=rev|1;
            

            n=n>>1;
        }
        return rev;
    }
}