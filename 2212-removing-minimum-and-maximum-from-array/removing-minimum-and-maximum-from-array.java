class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length ;
        if( n == 1 || n == 2 ) return n ;

        int min = 0 ;
        int max = 0 ;
        int mx = Integer.MIN_VALUE ;
        int mn = Integer.MAX_VALUE ;
        for(int i = 0 ; i < n ; i++){
            if( nums[i] > mx ){
                mx = nums[i] ;
                max = i ;
            }
            if( nums[i] < mn ){
                mn = nums[i] ;
                min = i ;
            }
        }

        int sc1 = Math.max(min,max)+1 ;
        int sc2 = n-Math.min(min,max) ;
        int sc3 ;
        if( max > min ) sc3 = n-max + min+1 ;
        else sc3 = n-min+max+1 ;

        return Math.min(sc3,Math.min(sc1,sc2)) ;
    }
}