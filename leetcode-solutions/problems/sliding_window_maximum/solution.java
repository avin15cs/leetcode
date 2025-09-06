class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Max Heap: store indices, compare by values
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int n = nums.length;
        int l = 0, r = 0;
        int ans[] = new int[n - k + 1];

        while (r < n) {
            // push [value, index]
            pq.offer(new int[]{nums[r], r});

            // when window is full
            if (r - l + 1 == k) {
                // remove all elements outside the window
                while (!pq.isEmpty() && pq.peek()[1] < l) {
                    pq.poll();
                }
                // now top is valid maximum
                ans[l] = pq.peek()[0];
                l++; // slide window
            }
            r++;
        }

        return ans;
    }
}