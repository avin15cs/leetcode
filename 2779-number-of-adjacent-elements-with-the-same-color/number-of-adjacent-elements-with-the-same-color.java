class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] result = new int[queries.length];
        int[] colors = new int[n];
        int count = 0;

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int color = queries[i][1];

            // If already colored, remove old contribution
            if (colors[index] != 0) {
                if (index > 0 && colors[index] == colors[index - 1])
                    count--;

                if (index < n - 1 && colors[index] == colors[index + 1])
                    count--;
            }

            // Paint new color
            colors[index] = color;

            // Add new contribution
            if (index > 0 && colors[index] == colors[index - 1])
                count++;

            if (index < n - 1 && colors[index] == colors[index + 1])
                count++;

            result[i] = count;
        }

        return result;
    }
}