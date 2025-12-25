class Solution {
    public int maximumUnits(int[][] arr, int k) {
        Arrays.sort(arr, (a,b)->b[1]-a[1]);

        int n=arr.length;

        int ans=0,i=0;
        while(k>0 && i<n) {
            int t=Math.min(arr[i][0],k);

            k=k-t;
            ans+=t*arr[i][1];
            i++;
        }

        return ans;
    }
}