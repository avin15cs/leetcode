class Solution {
    public int findMin(int[] nums) {
        
        int i=0,j=nums.length-1;
        int ans=nums[0];
        while(i<=j){
            int mid=i+(j-i)/2;
            
            if(nums[0]<=nums[mid])
                i=mid+1;
            
            else{
                j=mid-1;
                ans=Math.min(ans,nums[mid]);
            }
        }
        
        return ans;
    }
}