class Solution {
    public int[] plusOne(int[] digits) {
    int n = digits.length;

    for (int i = n - 1; i >= 0; i--) {
        if (digits[i] < 9) {
            digits[i]++;       // just increment and return
            return digits;
        }
        digits[i] = 0;         // set current to 0, carry 1 to next
    }

    // If we reached here, all digits were 9 → e.g., [9,9,9]
    int[] res = new int[n + 1];
    res[0] = 1;                // new number = 1000...
    return res;
}

}