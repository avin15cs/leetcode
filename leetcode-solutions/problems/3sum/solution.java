class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if (i > 0 && nums[i] == nums[i-1]) 
                continue;
            
            int j=i+1,k=n-1;

            while(j<k){
                int total=nums[i]+nums[j]+nums[k];
                if(total<0)
                    j++;
                else if(total>0)
                    k--;
                else {
                    list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;

                    while (nums[j] == nums[j-1] && j < k)
                        j++;

                    while(k<n-1 &&nums[k]==nums[k+1])
                        k--;
                }
            }

        }

        return list;
    }
}