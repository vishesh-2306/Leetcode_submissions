class Solution {
    
    public int stoneGameV(int[] stone) {
        int n = stone.length ;

        int[] pre = new int[n+1] ;
        pre[0] = stone[0] ;
        for(int i = 1 ; i < n ; i++){
            pre[i] = pre[i-1] + stone[i] ;
        }
        int[][] dp = new int[n+1][n+1] ;

        for(int l = n-1 ; l >= 0 ; l--){
            for(int r = l+1 ; r < n ; r++){
                int score = 0 ;
                for(int mid = l ; mid < r ; mid++){
                    int lsum = (l-1 >= 0) ? pre[mid] - pre[l-1] : pre[mid]  ; 
                    int rsum = pre[r] - pre[mid] ;
                    if( lsum > rsum ) score = Math.max(score,rsum+dp[mid+1][r]) ;
                    else if( lsum < rsum ) score = Math.max(score,lsum + dp[l][mid]) ;
                    else score = Math.max(score,Math.max(lsum + dp[l][mid],rsum + dp[mid+1][r])) ;

                }
                dp[l][r] = score ;
            }
        }

        return dp[0][n-1] ;
    }
}