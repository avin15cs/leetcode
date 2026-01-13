class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int[] prev = intervals[0];
        int overlap=0;
        for(int i=1;i<intervals.length;i++) {
            if(prev[1]>intervals[i][0]) 
                overlap++;
            else 
                prev = intervals[i];
        }
        return overlap;
    }
}