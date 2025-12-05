class Solution {
    public int minEatingSpeed(int[] piles, int n) {
        int h=0;
        for(int i: piles) {
            h=Math.max(i,h);
        }
        int l=1;
        while(l<=h) {
            int mid=l+(h-l)/2;
            long minSum=checkMin(piles,mid);
            if(minSum<=n) {
                h=mid-1;
            } else {
                l=mid+1;
            }
        }
        return l;
    }

    private long checkMin(int[] piles, int speed) {
        long hours=0;
        for(int pile: piles) {
            hours+=pile/speed;
            if(pile%speed>0)
                hours++;   
        }
        return hours;
    }
}