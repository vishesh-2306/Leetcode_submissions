class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n+1][n+1];

        int[] suf = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suf[i] = suf[i + 1] + piles[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                if (2 * m >= n - i) {
                    dp[i][m] = suf[i];
                    continue;
                }
                else{
                    for(int x = 1 ; x <= Math.min(2*m,n-i) ; x++){
                        dp[i][m] = Math.max(suf[i] - dp[i+x][Math.max(m,x)],dp[i][m]) ;
                    }
                }
            }
        }

        return dp[0][1] ;
    }
}