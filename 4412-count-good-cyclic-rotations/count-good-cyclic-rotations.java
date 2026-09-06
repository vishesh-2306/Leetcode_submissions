class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length ;
        long total = 0 ;
        long first = 0 ;
        for(int i = 0 ; i < n ; i++){
            total += nums[i] ;
            if( i < n/2 ) first += nums[i] ;
        }

        int cnt = 0 ;
        

        for(int i = 0 ; i < n ; i++){
            first -= nums[i] ;
            first += nums[(n/2+i)%n] ;
            if( first > total-first ) cnt++ ;
        }

        return cnt ;
    }
}