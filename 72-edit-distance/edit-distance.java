class Solution {
    public static int LCStabulation(String s1, String s2 ){
        int n = s1.length() ;
        int m = s2.length() ;

        int[][] dp = new int[n+1][m+1] ;

        for(int i = 0 ; i < n+1 ; i++){
            for( int j = 0 ; j < m + 1 ; j++){
                if( i == 0 || j == 0 ) dp[i][j] = 0 ;

                else{
                    if( s1.charAt(i-1) == s2.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1] ;
                    }
                    else {
                        dp[i][j] = Math.max( dp[i-1][j],dp[i][j-1] ) ;
                    }
                }
            }
        }

        return dp[n][m] ;
    }
    public int minDistance(String w1, String w2) {
        int n = w1.length() ;
        int m = w2.length() ;

        int[][] dp = new int[n+1][m+1] ;

        for(int i = 0 ; i < n+1 ; i++) dp[i][0] = i ;
        for(int j = 0 ; j < m+1 ; j++) dp[0][j] = j ;

        for(int i = 1 ; i < n+1 ; i++){
            for(int j = 1 ; j < m+1 ; j++){
                if( w1.charAt(i-1) == w2.charAt(j-1) ){
                    dp[i][j] = dp[i-1][j-1] ;
                }

                else{
                    int add = dp[i][j-1] + 1 ;
                    int delete = dp[i-1][j] + 1 ;
                    int replace = dp[i-1][j-1] + 1 ;
                    dp[i][j] = Math.min(Math.min(add,delete),replace) ;
                }
            }
        }

        return dp[n][m] ;
    }
}