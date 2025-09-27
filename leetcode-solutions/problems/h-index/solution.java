class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n=citations.length;
        int max=0;
        int h=0;
        for(int i=0;i<n;i++) {
            h=Math.min(n-i,citations[i]);
            max=Math.max(max,h);
        }

        return max;
    }
}