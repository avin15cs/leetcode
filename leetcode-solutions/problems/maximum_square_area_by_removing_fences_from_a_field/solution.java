class Solution {

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        final long MOD = 1_000_000_007L;

        // Include border fences (cannot be removed)
        int[] h = new int[hFences.length + 2];
        int[] v = new int[vFences.length + 2];

        h[0] = 1;
        h[h.length - 1] = m;
        System.arraycopy(hFences, 0, h, 1, hFences.length);

        v[0] = 1;
        v[v.length - 1] = n;
        System.arraycopy(vFences, 0, v, 1, vFences.length);

        Arrays.sort(h);
        Arrays.sort(v);

        // Store all possible horizontal distances
        Set<Integer> horizontalDistances = new HashSet<>();
        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                horizontalDistances.add(h[j] - h[i]);
            }
        }

        long maxSide = -1;

        // Check vertical distances against horizontal ones
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                int dist = v[j] - v[i];
                if (horizontalDistances.contains(dist)) {
                    maxSide = Math.max(maxSide, dist);
                }
            }
        }

        if (maxSide == -1) {
            return -1;
        }

        return (int) ((maxSide * maxSide) % MOD);
    }
}