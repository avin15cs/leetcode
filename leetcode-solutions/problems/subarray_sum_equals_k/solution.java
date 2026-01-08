class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum=new int[n];
        prefixSum[0]=nums[0];
        
        for( int i=1; i<n; i++) {
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<n;i++) {
            if(prefixSum[i]-k==0)
                count++;
            
            int val = prefixSum[i]-k;
            if(map.get(val)!=null)
                count+=map.get(val);
            
            map.put(prefixSum[i],map.getOrDefault(prefixSum[i],0)+1);
        }

        return count;
    }

}