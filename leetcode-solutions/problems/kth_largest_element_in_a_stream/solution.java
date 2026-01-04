class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++) {
            addInQueue(nums[i]);
        }
    }
    
    public int add(int val) {
        addInQueue(val);
        return pq.peek();
    }

    private void addInQueue(int val) {
        pq.add(val);
        if (pq.size() > k) {
            pq.remove();   
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */