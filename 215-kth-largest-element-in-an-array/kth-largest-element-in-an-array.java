class Solution {

    //Heap Sort
    // public int findKthLargest(int[] nums, int k) {
    //     PriorityQueue<Integer> pq = new PriorityQueue<>();

    //     for(int num: nums) {
    //         pq.add(num);
    //         if(pq.size()>k)
    //             pq.remove();
    //     }

    //     return pq.peek();
    // }
    
    //QuickSelect
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        int target = n-k;

        int left = 0, right = n-1;

        while(left<=right) {
            int pos = partition(nums, left, right);

            if(pos == target)
                return nums[pos];

            else if(pos<target)
                left = pos+1;

            else
                right = pos-1;
        }
        return -1;
    }


    int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;

        for(int j=left;j<right;j++) {
            if(nums[j]<pivot) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, right);
        return i;
    }
    
    void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
