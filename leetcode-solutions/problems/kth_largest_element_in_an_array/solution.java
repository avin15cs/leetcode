class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        int i=0,j=n-1;

        int pos=n-k;

        while(i<=j){
            int pivot=partition(nums, i, j);

            if(pivot< pos){
                i=pivot+1;
            }

            else if(pivot>pos){
                j=pivot-1;
            }
            else
                return nums[pivot];
        }

        return -1;

    }

    private int partition(int[] nums, int l, int h){
        int i=l,j=h;
        int pivot=nums[l];

        while(i<j){
            while(i<=h && nums[i]<=pivot)   i++;

            while(j>=l && nums[j]>pivot)    j--;

            if(i<j) swap(nums,i,j);
        }

        swap(nums,j,l);

        return j;
    }

    private void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}