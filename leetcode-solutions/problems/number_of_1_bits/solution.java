public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int check, count =0;
        for(int i=0;i<32;i++)
        {
            check = n & 1;
            if(check!=0)
                count++;
            n=n>>1;

        }
        
        return count;
        
    }
}