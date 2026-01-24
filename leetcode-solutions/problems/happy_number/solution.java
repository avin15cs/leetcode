class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen=new HashSet<>();
        while(n!=1 && !seen.contains(n)) {
            seen.add(n);
            int rem = 0, sum = 0;
            while(n!=0) {
                rem = n%10;
                sum = sum+rem*rem;
                n = n/10;
            }
            n = sum;
        }

        return n==1;
    }
}