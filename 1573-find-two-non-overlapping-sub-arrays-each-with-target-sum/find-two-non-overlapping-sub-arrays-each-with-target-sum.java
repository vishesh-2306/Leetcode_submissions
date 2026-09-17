class Solution {
    public int minSumOfLengths(int[] arr, int k) {
        int n = arr.length;
        int INF = Integer.MAX_VALUE / 2;

        
        int[] best = new int[n];
        Arrays.fill(best, INF);

        int l = 0;
        int sum = 0;
        int ans = INF;
        
        for(int r = 0 ; r < n ; r++){
            sum += arr[r] ;

            while( sum > k ){
                sum -= arr[l++] ;
            }

            if( sum == k ){

                int len = r-l+1 ;

                if( l > 0 && best[l-1] != INF ){
                    ans = Math.min(ans,len+best[l-1]) ;
                }

                best[r] = len ;
            }

            if (r > 0) {
                best[r] = Math.min(best[r], best[r - 1]);
            }

        }

        

        return ans == INF ? -1 : ans;
    }   
}