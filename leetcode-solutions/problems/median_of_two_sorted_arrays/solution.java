class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1=nums1.length;
        int l2=nums2.length;

        int l=l1+l2;
        int m=l/2;
        int n=m-1;

        int i=0,j=0;
        int count=0;
        int num1=-1,num2=-1;
        while(i<l1 && j<l2) {
            if(nums1[i]<nums2[j]) {
                if(count==m)
                    num1=nums1[i];
                if(count==n)
                    num2=nums1[i];
                
                i++;
            } else {
                if(count==m)
                    num1=nums2[j];
                if(count==n)
                    num2=nums2[j];
                j++;
            }
            count++;
        }

        while(i<l1) {
            if(count==m)
                num1=nums1[i];
            if(count==n)
                num2=nums1[i];
            
            count++;
            i++;
        }
        while(j<l2) {
            if(count==m)
                num1=nums2[j];
            if(count==n)
                num2=nums2[j];
            
            count++;
            j++;
        }

        if(l%2==1)
            return num1;
        return (double)((double)(num1+num2)/2.0);
    }
}