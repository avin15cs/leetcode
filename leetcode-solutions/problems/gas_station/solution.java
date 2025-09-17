class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int j=0;

        int totalGas = 0,totalCost = 0;
        for(int i=0;i<gas.length;i++) {
            totalGas+=gas[i];
            totalCost+=cost[i];
        }

        if(totalGas<totalCost)
            return -1;
            
        // for(int i=0;i<n;i++){
            
        //     if(gas[i]>=cost[i]) {
        //         j=i;
        //         int total=0;
        //         while(true) {
        //             total+=gas[j]-cost[j];
        //             if(total<0) break;
        //             j=(j+1)%n;
        //             if(i==j)
        //                 return i;
        //         }
        //     }
        // }

        // return -1;
        int currentGas = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                start = i + 1;
            }
        }

        return start;        

    }
}