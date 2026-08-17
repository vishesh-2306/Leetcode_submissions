class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length ;
        int score = 0 ;

        int l = k ;
        int r = k ;
        int min = nums[k] ;
        int ans = min;

        while( l > 0 || r < n-1 ){
            int lnum = ( l > 0 ) ? nums[l-1] : Integer.MIN_VALUE ; 
            int rnum = ( r < n-1 ) ? nums[r+1] : Integer.MIN_VALUE ; 

            if( lnum >  rnum ){
                min = Math.min(min,lnum) ;
                l-- ;
            } else{
                min = Math.min(min,rnum) ;
                r++ ;
            }

            ans = Math.max(ans,min*(r-l+1)) ;
        }

        return ans ;
    }
}