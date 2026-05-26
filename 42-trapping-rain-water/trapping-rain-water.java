class Solution {
    // public int trap(int[] height) {
    //     int n = height.length;
    //     int[] left = new int[n];
    //     int[] right = new int[n];
    //     int sum=0; 
    //     left[0]=height[0];
    //     right[n-1]=height[n-1];
    //     for(int i=1;i<n;i++) {
    //         left[i]=Math.max(left[i-1],height[i]);
    //         right[n-i-1]=Math.max(right[n-i],height[n-i-1]);
    //     }

    //     for(int i=0;i<n;i++) {
    //         sum+=Math.min(left[i],right[i])-height[i];
    //     }

    //     return sum;
    // }


    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        int left = 0, right = height.length-1;

        while(left<=right) {
            if(height[left]<height[right]) {
                if(leftMax<height[left])
                    leftMax = height[left];

                else
                    water+=leftMax-height[left];

                left++;
            } else {
                if(rightMax<height[right])
                    rightMax = height[right];
                
                else
                    water+=rightMax-height[right];

                right--;
            }
        } 

        return water;
    }
}