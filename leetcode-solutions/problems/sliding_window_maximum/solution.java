class Solution {
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     int n=nums.length;

    //     int[] left=new int[n];
    //     int[] right=new int[n];

    //     left[0]=nums[0];
    //     right[n-1]=nums[n-1];

    //     //precompute left and right array

    //     for(int i=1;i<n;i++) {
    //         if((i+1)%k==0) {
    //             left[i]=nums[i];
    //         } else {
    //             left[i]=Math.max(left[i-1],nums[i]);
    //         }

    //         int j=n-i-1;
    //         if((j+1)%k==0) {
    //             right[j]=nums[j];
    //         } else {
    //             right[j]=Math.max(right[j+1],nums[j]);
    //         }
    //     }

    //     // for(int j=n-2;j>=0;j--) {
    //     //     if((j+1)%k==0) {
    //     //         right[j]=nums[j];
    //     //     } else {
    //     //         right[j]=Math.max(right[j+1],nums[j]);
    //     //     }
    //     // }

    //     int out[] = new int[n-k+1];
    //     for(int i=0;i+k<=n;i++) {
    //         out[i]=Math.max(left[i+k-1],right[i]);
    //     }

    //     return out;
    // }

    //Priority Queue Method => TLE
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    //     ArrayList<Integer> list = new ArrayList<>();
    //     int j=0;
    //     for(;j<k;j++) 
    //         pq.add(nums[j]);

    //     list.add(pq.peek());
    //     int i=0;
    //     while(j<nums.length) {
    //         pq.remove(nums[i]);
    //         i++;

    //         pq.add(nums[j]);
    //         list.add(pq.peek());
    //         j++;
    //     }

    //     int[] ans = new int[list.size()];
    //     for(i=0;i<list.size();i++)
    //         ans[i]=list.get(i);
    //     return ans;
        
    // }


    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     int n = nums.length;
    //     int[] ans = new int[n-k+1];
    //     Deque<Integer> dq = new ArrayDeque<>();

    //     for(int i=0;i<k;i++) {
            
    //        while(!dq.isEmpty() && nums[i]>nums[dq.peekLast()])
    //             dq.removeLast();
            
    //         dq.addLast(i);
    //     }

    //     ans[0] = nums[dq.peekFirst()];
    //     int idx = 1;
    //     for(int i=k;i<n;i++) {
    //         if(!dq.isEmpty() && dq.peekFirst()<=i-k)
    //             dq.removeFirst();

    //         while(!dq.isEmpty() && nums[i]>nums[dq.peekLast()])
    //             dq.removeLast();

    //         dq.addLast(i);

    //         ans[idx++]=nums[dq.peekFirst()];
    //     }

    //     return ans;
    // }

    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new ArrayDeque<>();

        int n = nums.length;
        int i=0,j=0;
        int[] ans = new int[n-k+1];
        while(j<n) {

            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[j])
                dq.removeLast();
            
            dq.addLast(j);

            if(j-i+1 == k) {
                ans[i] = nums[dq.peekFirst()];

                if(i==dq.peekFirst())
                    dq.removeFirst();
                
                i++;
            }

            j++;

        }

        return ans;
    }
}