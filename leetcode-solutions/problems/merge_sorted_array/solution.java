class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m+n,i=m,j=n;
        while(i>0 && j>0){
            if(nums1[i-1]>nums2[j-1]){
                nums1[k-1]=nums1[i-1];
                i--;
            }
            else{
                nums1[k-1]=nums2[j-1];
                j--;
            }
            k--;
        }

        while(j>0){
            nums1[k-1] = nums2[j-1];
            j--;
            k--;
        }
    }
}