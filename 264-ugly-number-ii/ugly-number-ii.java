class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0]=1;
        int i=0,j=0,k=0;

        for(int l=1;l<n;l++) {
            int next2=ugly[i]*2;
            int next3=ugly[j]*3;
            int next5=ugly[k]*5;
            int nextUgly = Math.min(next2,Math.min(next3, next5));
            ugly[l]=nextUgly;

            if(nextUgly==next2) i++;
            if(nextUgly==next3) j++;
            if(nextUgly==next5) k++;
        }

        return ugly[n-1];
    }
}