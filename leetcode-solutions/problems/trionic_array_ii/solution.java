// class Solution {

//     private static final long NEG_INF = (long) -1e15;
//     private long[][] dp;
//     private int[] nums;
//     private int n;

//     public long maxSumTrionic(int[] nums) {
//         this.nums = nums;
//         this.n = nums.length;
//         this.dp = new long[n][4];

//         for (int i = 0; i < n; i++) {
//             Arrays.fill(dp[i], Long.MIN_VALUE);
//         }

//         return solve(0, 0);
//     }

//     private long solve(int i, int state) {
//         if (i == n) {
//             return state == 3 ? 0 : NEG_INF;
//         }

//         if (dp[i][state] != Long.MIN_VALUE) {
//             return dp[i][state];
//         }

//         long res = NEG_INF;

//         // 1️⃣ Skip allowed only if not started
//         if (state == 0) {
//             res = Math.max(res, solve(i + 1, 0));
//         }

//         // 2️⃣ Try taking nums[i]
//         if (i + 1 < n) {
//             int curr = nums[i];
//             int next = nums[i + 1];

//             // Start first increasing (must see ↑)
//             if (state == 0 && curr < next) {
//                 res = Math.max(res,
//                         curr + solve(i + 1, 1));
//             }

//             // First increasing
//             else if (state == 1) {
//                 if (curr < next) {
//                     res = Math.max(res,
//                             curr + solve(i + 1, 1));
//                 } else if (curr > next) {
//                     res = Math.max(res,
//                             curr + solve(i + 1, 2));
//                 }
//             }

//             // Decreasing
//             else if (state == 2) {
//                 if (curr > next) {
//                     res = Math.max(res,
//                             curr + solve(i + 1, 2));
//                 } else if (curr < next) {
//                     res = Math.max(res,
//                             curr + solve(i + 1, 3));
//                 }
//             }

//             // Final increasing
//             else if (state == 3 && curr < next) {
//                 res = Math.max(res,
//                         curr + solve(i + 1, 3));
//             }
//         }

//         // 3️⃣ If already in final state, you may end here
//         if (state == 3) {
//             res = Math.max(res, nums[i]);
//         }

//         return dp[i][state] = res;
//     }
// }



class Solution {

    private static final long NEG_INF = (long) -1e15;

    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) return 0;

        long inc1 = NEG_INF; // first increasing
        long dec  = NEG_INF; // decreasing
        long inc2 = NEG_INF; // final increasing

        long ans = NEG_INF;

        for (int i = 1; i < n; i++) {
            int a = nums[i - 1];
            int b = nums[i];

            long newInc1 = NEG_INF;
            long newDec  = NEG_INF;
            long newInc2 = NEG_INF;

            // ↑ first increasing
            if (b > a) {
                newInc1 = Math.max(inc1 + b, (long) a + b);
            }

            // ↓ decreasing
            if (b < a) {
                newDec = Math.max(dec + b, inc1 + b);
            }

            // ↑ final increasing
            if (b > a) {
                newInc2 = Math.max(inc2 + b, dec + b);
            }

            inc1 = newInc1;
            dec  = newDec;
            inc2 = newInc2;

            ans = Math.max(ans, inc2);
        }

        return ans;
    }
}
