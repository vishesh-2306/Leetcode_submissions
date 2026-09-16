class Solution {
    public int numberOfSets(int n, int k) {

        long MOD = 1_000_000_007L;
        long[][] dp = new long[n][k + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        long[] sum = new long[k + 1];
        sum[0] = 1;

        for (int i = 1; i < n; i++) {

            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] = (dp[i][j] + sum[j - 1]) % MOD;
            }

            for (int j = 0; j <= k; j++) {
                sum[j] = (sum[j] + dp[i][j]) % MOD;
            }
        }

        return (int) dp[n - 1][k];
    }
}