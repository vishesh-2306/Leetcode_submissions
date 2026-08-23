class Solution {
    public int shipWithinDays(int[] wt, int days) {
        int max = 0 , sum = 0 ;
        for(int x : wt){
            max = Math.max(max,x) ;
            sum += x ;
        }
        int low = max ;
        int high = sum ;

        while ( low < high){
            int mid = ( low + high) / 2 ;

            int total = 0 ;
            int curr = 1 ;
            for(int x : wt){
                if( total + x > mid ) {
                    curr++ ;
                    total = 0 ;
                }
                total += x ;

                if( curr > days ) break ;
            }

            if( curr > days ) low = mid+1 ;
            else high = mid ;
        }

        return low ;
    }
}