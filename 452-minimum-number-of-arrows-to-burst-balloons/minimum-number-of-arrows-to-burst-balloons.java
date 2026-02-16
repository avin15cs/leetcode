class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        Arrays.sort(points,(a,b)->Integer.compare(a[1], b[1]));

        int count=1;
        int[] prev=points[0];
        for(int[] point: points) {
            if(prev[1]<point[0]) {
                count++;
                prev=point;
            }
        }

        return count;
    }
}