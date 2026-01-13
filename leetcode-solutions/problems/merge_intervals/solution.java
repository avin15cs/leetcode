class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> list=new ArrayList<>();
        
        int[] prev = intervals[0];

        for(int i=1; i<intervals.length; i++) {
            int[] cur = intervals[i];
            if(cur[0]<=prev[1]) {
                prev[1]=Math.max(prev[1],cur[1]);
            } else {
                list.add(prev);
                prev=cur;
            }
        }

        list.add(prev);

        return list.toArray(new int[0][]);
    }
}