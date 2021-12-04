class Solution {
    public void sortColors(int[] nums) {
        
        int l=0;
        int m=0;
        int h=nums.length-1;
        
        while(m<=h)
        {
            int x=nums[m];
            if(x==0)
            {
                swap(nums,l,m);
                l++;
                m++;
            }
            else if(x==1)
                m++;
            
            else{
                swap(nums,m,h);
                h--;
            }
        }
    }
public void swap(int[] nums, int i, int j) {
	int temp = nums[i];
	nums[i] = nums[j];
	nums[j] = temp;
}
}