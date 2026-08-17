class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length ;

        int i = 0 ; 
        while( i < n && nums[i] == 0 ) i++ ;
        if( i == n ) return 0 ;

        int xor = nums[0] ;
        for(i = 1 ; i < n ; i++){
            xor ^= nums[i] ;
        }
        if( xor != 0 ) return n ;
        return n-1 ;
    }
}