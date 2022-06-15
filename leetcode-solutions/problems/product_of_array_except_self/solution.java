class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int p=1,n=nums.length;
        int[] res=new int[n];
        res[0]=1;
        
        for(int i=1;i<nums.length;i++){
            p=p*nums[i-1];
            res[i]=p;
        }
        
        p=1;
        for(int i=n-2;i>=0;i--){
            p=p*nums[i+1];
            res[i]=res[i]*p;
        }
        
        return res;
    }
}