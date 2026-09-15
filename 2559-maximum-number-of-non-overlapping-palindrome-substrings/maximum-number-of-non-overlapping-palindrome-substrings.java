class Solution {
    private Boolean isPalindrome(String s,int i,int j){

        if( i > j ){
            pal[i][j] = 1 ;
            return true ;
        }

        if( pal[i][j] != -1 ) return (pal[i][j] == 1) ;

        if( s.charAt(i) == s.charAt(j) ) pal[i][j] = (isPalindrome(s,i+1,j-1)) ? 1 : 0 ;
        else pal[i][j] = 0 ;

        return (pal[i][j] == 1 ) ;
    }

    int n ;
    int[][] dp ;
    int[][] pal ;

    private int solve(String s,int k,int i,int j){
        if( i >= n || j >= n ) return 0 ;

        if( dp[i][j] != -1 ) return dp[i][j] ;

        int take = Integer.MIN_VALUE ;

        if( isPalindrome(s,i,j) ){
            take = 1 + solve(s,k,j+1,j+k) ;
        }

        int grow = solve(s,k,i,j+1) ;
        int slide = solve(s,k,i+1,j+1) ;

        dp[i][j] = Math.max(take,Math.max(grow,slide)) ;
        
        return dp[i][j] ;

    }
    public int maxPalindromes(String s, int k) {
        n = s.length() ;
        if( k == 1 ) return n ;
        dp = new int[n][n] ;
        pal = new int[n][n] ;

        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i],-1) ;
            Arrays.fill(pal[i],-1) ;
        }
        
        return solve(s,k,0,k-1) ;
    }
}