class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod=1;
        int n=nums.length;
        int[] res=new int[n];
        res[0]=prod;

        for(int i=1;i<n;i++){
            prod=prod*nums[i-1];
            res[i]=prod;
        }
        System.out.println(Arrays.toString(res));
        prod=1;
        for(int i=n-2;i>=0;i--){
            prod=prod*nums[i+1];
            res[i]=res[i]*prod;
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
}