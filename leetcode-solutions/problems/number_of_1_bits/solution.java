class Solution {
    public int hammingWeight(int n) {
        int count=0;
        for(int i=1;i<32;i++) {
            int mask=n&1;
            if(mask==1)
                count++;
            
            n=n>>1;
        }

        return count;
    }
}