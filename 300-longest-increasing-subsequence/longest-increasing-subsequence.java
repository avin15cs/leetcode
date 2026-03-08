class Solution {
    // public int lengthOfLIS(int[] nums) {
    //     List<Integer> list = new ArrayList<>();
    //     list.add(nums[0]);

    //     for(int i=1;i<nums.length;i++) {
    //         if(nums[i]>list.get(list.size()-1))
    //             list.add(nums[i]);

    //         else {
    //             int pos = findPos(list, nums[i]);
    //             list.set(pos, nums[i]);
    //         }       
    //     }
    //     return list.size();
    // }

    // int findPos(List<Integer> list, int target) {
    //     int i=0, j=list.size()-1;
    //     while(i<=j) {
    //         int mid = i+(j-i)/2;
    //         if(list.get(mid)<target)
    //             i = mid+1;
    //         else
    //             j = mid-1;
    //     }
    //     return i; 
    // }

    public int lengthOfLIS(int[] nums) {
        List<Integer> list=new ArrayList<>();

        list.add(nums[0]);

        int n=nums.length;

        for(int i=1;i<n;i++) {
            if(list.get(list.size()-1)<nums[i])
                list.add(nums[i]);

            else {
                int pos=findpos(list, nums[i]);
                list.set(pos, nums[i]);
            }
        }

        return list.size();
    }

    int findpos(List<Integer> list, int target) {
        int i=0,j=list.size()-1;

        while(i<=j) {
            int mid = i+(j-i)/2;
            if(list.get(mid)<target)
                i=mid+1;
            else
                j=mid-1;
        }

        return i;
    }
}