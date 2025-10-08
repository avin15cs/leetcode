class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans=new int[spells.length];
        int k=0;
        for(int s: spells){
            int i=0,j=potions.length-1;
            while(i<=j) {
                int mid=i+(j-i)/2;
                if((long)potions[mid]*s>=success) {
                    ans[k]=potions.length-mid;
                    j=mid-1;
                }
                else{
                    i=mid+1;
                }
            }
            k++;
        }

        return ans;
    }
}