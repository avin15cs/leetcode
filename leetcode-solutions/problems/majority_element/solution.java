class Solution {
    // public int majorityElement(int[] nums) {
    //     Map<Integer,Integer> map=new HashMap<>();
    //     for(int i:nums){
    //         map.put(i,map.getOrDefault(i,0)+1);
    //         if(2*map.get(i)>nums.length){
    //             return i;
    //         }
    //     }

    //     return -1;
    // }

        public int majorityElement(int[] nums) {
            int count=0,candidate=0;
            for(int i:nums){
                if(count==0){
                    candidate=i;
                }
                if(candidate!=i)
                    count--;
                else
                    count++;
            }
            return candidate;
        }
}