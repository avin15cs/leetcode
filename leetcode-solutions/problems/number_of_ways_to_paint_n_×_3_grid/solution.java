
class Solution {
    int MOD = 1_000_000_007;
    Long[][] memo;

    public int numOfWays(int n) {
        memo = new Long[n + 1][2];
        long res = (dfs(1, 0, n) + dfs(1, 1, n)) % MOD;
        return (int) res;
    }

    private long dfs(int i, int type, int n) {
        if (i == n) return 6;

        if (memo[i][type] != null)
            return memo[i][type];

        long ways;
        if (type == 0) { // ABA
            ways = (3 * dfs(i + 1, 0, n) +
                    2 * dfs(i + 1, 1, n)) % MOD;
        } else { // ABC
            ways = (2 * dfs(i + 1, 0, n) +
                    2 * dfs(i + 1, 1, n)) % MOD;
        }

        return memo[i][type] = ways;
    }

}