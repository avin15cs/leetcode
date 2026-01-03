class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int c1=0, c2=0;
        int candidate1=0, candidate2=0;

        for(int num: nums) {
            if(num==candidate1)
                c1++;
            else if(num==candidate2)
                c2++;
            else if(c1==0) {
                candidate1=num;
                c1=1;
            } else if(c2==0) {
                candidate2=num;
                c2=1;
            } else {
                c1--;
                c2--;
            }
        }
        c1=0;
        c2=0;

        for(int num: nums) {
            if(num==candidate1)
                c1++;
            
            else if(num==candidate2)
                c2++;
        }

        if(c1>nums.length/3)
            list.add(candidate1);
        

        if(c2>nums.length/3)
            list.add(candidate2);

        return list;

    }
}