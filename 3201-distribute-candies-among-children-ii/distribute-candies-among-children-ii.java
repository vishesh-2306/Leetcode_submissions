class Solution {
    public long distributeCandies(int n, int limit) {
        long ways = 0 ;

        for(int i = 0 ; i <= limit && i <= n; i++){
            long low = Math.max(0L,n-i-limit) ;
            long high = Math.min(limit, n - i);
            ways += 1L*Math.max(0L,high-low+1) ;
        }

        return ways ;
    }
}