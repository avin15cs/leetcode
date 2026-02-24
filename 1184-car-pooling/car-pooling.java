class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] car = new int[1001];
        for(int[] trip: trips) {
            int requiredSeats = trip[0];
            int from = trip[1];
            int to = trip[2];

            car[from]+=requiredSeats;
            car[to]-=requiredSeats;
        }
        int curSeat=0;
        for(int i=0;i<1001;i++) {
            curSeat+=car[i];
            if(curSeat>capacity)
                return false;
        }

        return true;
    }
}