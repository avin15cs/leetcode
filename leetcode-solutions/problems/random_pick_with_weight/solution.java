class Solution {
    private int[] prefix;
    private int totalSum;
    private Random random;
    public Solution(int[] w) {
        int n=w.length;
        prefix = new int[n];
        random = new Random();

        prefix[0]=w[0];
        for(int i=1;i<n;i++) {
            prefix[i]=prefix[i-1]+w[i];
        }

        totalSum = prefix[n-1];
    }
    
    public int pickIndex() {
        int r = random.nextInt(totalSum) + 1;

        int i=0,j=prefix.length-1;

        while(i<j) {
            int mid = i+(j-i)/2;

            if(prefix[mid]<r) {
                i=mid+1;
            } else {
                j=mid;
            }
        }

        return i;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */