class Solution {
    // public int largestRectangleArea(int[] heights) {
        // int n = heights.length;
        // Stack<Integer> st = new Stack<>();
        // int[] left = new int[n];
        // int[] right = new int[n];

        // int maxArea = 0;
        // for(int i=0;i<n;i++) {
        //     while(!st.isEmpty() && heights[i]<=heights[st.peek()]) {
        //         st.pop();
        //     }
        //     left[i]=st.isEmpty()?-1:st.peek();
        //     st.push(i);
        // }

        // st.clear();

        // for(int i=n-1;i>=0;i--) {
        //     while(!st.isEmpty() && heights[i]<=heights[st.peek()])
        //         st.pop();

        //     right[i]=st.isEmpty()?n:st.peek();
        //     st.push(i);
        // }

        // for(int i=0;i<n;i++) {
        //     int width = right[i]-left[i]-1;
        //     maxArea=Math.max(maxArea, width*heights[i]);
        // }

        // return maxArea;
    // }

        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            Stack<Integer> stack = new Stack<>();
            int maxArea = 0;

            for (int i = 0; i <= n; i++) {
                int h = (i == n) ? 0 : heights[i];

                while (!stack.isEmpty() && h < heights[stack.peek()]) {
                    int height = heights[stack.pop()];
                    int rightBoundary = i;
                    int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
                    int width = rightBoundary - leftBoundary - 1;
                    maxArea = Math.max(maxArea, height * width);
                }

                stack.push(i);
            }

            return maxArea;
        }
}