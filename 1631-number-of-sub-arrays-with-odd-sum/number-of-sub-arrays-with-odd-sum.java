class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length ;
        int[] pre = new int[n+1] ;
        for(int i = 1 ; i <= n ; i++ ) {
            pre[i] = pre[i-1] + arr[i-1] ;
        } 
        long odd = 0 ;
        long even = 0 ;
        long MOD = 1_000_000_007 ;
        long cnt = 0 ;
        for(int i = 1 ; i <= n ; i++){
            if( pre[i] % 2 == 0 ){
                cnt = (cnt+odd%MOD)%MOD ;
                even = (even+1)%MOD ;
            }
            else{ 
                cnt = (cnt+(even)%MOD+1)%MOD ;
                odd = (odd+1)%MOD ;
            }

        }

        return (int) cnt ;
    }
}