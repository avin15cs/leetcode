class Solution {
    public void rotate(int[] nums, int k) {
//         if(nums.length==0) return;
        
//         int nums2[]=new int[nums.length];
//         int j=0;
//         for(int i=nums.length-k;i<nums.length;i++){
//             nums2[j++]=nums[i];
//         }
//         j=0;
//         for(int i=k;i<nums.length;i++)
//             nums2[i]=nums[j++];
        
//         for(int i=0;i<nums.length;i++)
//             nums[i]=nums2[i];
        
        int n=nums.length;
        if(n==0||n==1||k==0)
            return;
        
        k = k % nums.length;
        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);
    }
    
    void reverse(int[] nums, int low, int high) {
        
        while(low<high) {
            int temp= nums[low];
            nums[low]=nums[high];
            nums[high]=temp;
            
            low++;
            high--;
        }
    }
}