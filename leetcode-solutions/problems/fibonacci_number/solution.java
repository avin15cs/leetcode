class Solution {
    public int fib(int n) {
        if(n==0||n==1)
            return n;

        // return fib(n-1)+fib(n-2);

        int prev = 0, cur = 1;
        int i=1;
        while(i!=n) {
            int next = prev + cur;
            prev = cur;
            cur = next;
            i++;
        }

        return cur;
    }
}