class Solution {

    //Regular way
    public int[] twoSum(int[] nums, int target) {
        int i=0,j=nums.length-1;

        while(i<j){
            int sum=nums[i]+nums[j];
            if(sum<target) i++;

            else if(sum>target) j--;

            else return new int[]{i+1,j+1};
        }

        return new int[]{-1,-1};
    }

    //Using HashMap
    // public int[] twoSum(int[] numbers, int target) {
    //     Map<Integer, Integer> map = new HashMap<>();
    
    //     for (int i = 0; i < numbers.length; i++) {
    //         int complement = target - numbers[i];
            
    //         if (map.containsKey(complement)) {
    //             return new int[]{map.get(complement) + 1, i + 1};
    //         }
            
    //         map.put(numbers[i], i);
    //     }
        
    //     return new int[]{-1, -1};
    // }

    //Using Binary Search
    // public int[] twoSum(int[] numbers, int target) {
    //     for (int i = 0; i < numbers.length; i++) {
    //         int left = i + 1;
    //         int right = numbers.length - 1;
    //         int tmp = target - numbers[i];
            
    //         while (left <= right) {
    //             int mid = left + (right - left) / 2;
                
    //             if (numbers[mid] == tmp) {
    //                 return new int[]{i + 1, mid + 1};
    //             } else if (numbers[mid] < tmp) {
    //                 left = mid + 1;
    //             } else {
    //                 right = mid - 1;
    //             }
    //         }
    //     }
        
    //     return new int[]{-1, -1};
    // }
}