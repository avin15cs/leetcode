class Solution {
    public int reverse(int x) {
        long max = 2147483647l;
        long rev=0;
        boolean sign=x<0;
        x=Math.abs(x);
        while(x>0) {
            int rem= x%10;
            rev = rev* 10 + rem;
            x=x/10;
        }
        if(rev>max)
            return 0;
        if(sign)
            return -(int)rev;
        return (int)rev;
    }
}