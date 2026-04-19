class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] ngr = new int[n];
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=n-1;i>=0;i--) {
            map.put(nums2[i], i);
            while(!st.isEmpty() && st.peek()<=nums2[i])
                st.pop();

            ngr[i]=st.isEmpty()?-1:st.peek();

            st.push(nums2[i]);
        }
        int m=nums1.length;
        int[] res = new int[m];
        for(int i=0;i<m;i++) {
            res[i]=ngr[map.get(nums1[i])];
        }

        return res;
    }
}