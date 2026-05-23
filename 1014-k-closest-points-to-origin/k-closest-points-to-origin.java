class Solution {
    // public int[][] kClosest(int[][] points, int k) {
    //     PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(b[0]*b[0]+b[1]*b[1]-(a[0]*a[0]+a[1]*a[1])));

    //     for(int[] point: points) {
    //         pq.add(point);
    //         if(pq.size()>k)
    //             pq.remove();
    //     }

    //     return pq.toArray(new int[pq.size()][]);
    // }

    public int[][] kClosest(int[][] points, int k) {

        int left = 0;
        int right = points.length - 1;

        while (left <= right) {

            int pivotIndex = partition(points, left, right);

            if (pivotIndex == k - 1)
                break;

            else if (pivotIndex < k - 1)
                left = pivotIndex + 1;

            else
                right = pivotIndex - 1;
        }

        return Arrays.copyOfRange(points, 0, k);
    }

    int partition(int[][] points, int left, int right) {

        int pivotDist = distance(points[right]);

        int i = left;

        for (int j = left; j < right; j++) {

            if (distance(points[j]) <= pivotDist) {

                swap(points, i, j);
                i++;
            }
        }

        swap(points, i, right);

        return i;
    }

    int distance(int[] point) {

        return point[0] * point[0]
             + point[1] * point[1];
    }

    void swap(int[][] points, int i, int j) {

        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}