class Solution {
    public int coinChange(int[] coins, int amt) {
        Arrays.sort(coins) ;
        int n = coins.length ;

        int[][] dp = new int[n+1][amt+1] ;
        int MOD = Integer.MAX_VALUE ;
        for(int i = 0 ; i <= n ; i++){
            Arrays.fill(dp[i],MOD) ;
        }

        for(int i = 0 ; i <= n ; i++) dp[i][0] = 0 ;

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= amt ; j++){
                int take = Integer.MAX_VALUE ;
                int notTake = dp[i-1][j] ;
                if(coins[i-1] <= j ) {
                    if( dp[i][j-coins[i-1]] != MOD ) take = 1+dp[i][j-coins[i-1]] ;
                }

                dp[i][j] = Math.min(take,notTake) ;
            }
        }

        return (dp[n][amt] == MOD ) ? -1 : dp[n][amt] ;
    }
}