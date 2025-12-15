class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[1]-b[1]);

        List<int[]> list=new ArrayList<>();

        int[] prev=intervals[0];
        int overlap=0;
        for(int i=1;i<intervals.length;i++) {
            int[] interval=intervals[i];
            if(interval[0]<prev[1])
                overlap++;
            else
                prev=interval;
        }

        return overlap;
    }
}