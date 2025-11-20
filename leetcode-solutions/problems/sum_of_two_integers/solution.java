class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;  // carry
            a = a ^ b;                 // addition without carry
            b = carry;                 // apply carry for next iteration
        }
        return a;
    }
}