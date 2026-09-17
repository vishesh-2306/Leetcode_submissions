class Solution {
    public int minSumOfLengths(int[] arr, int k) {
        int n = arr.length ;
        HashMap<Integer,Integer> map = new HashMap<>() ;
        int s  = 0 ;
        map.put(0,-1) ;
        int[] pre = new int[n] ;
        Arrays.fill(pre,-1) ;
        
        for(int i = 0 ; i < n ; i++){
            if( map.containsKey(s-k) ) pre[i] = (i-1) - map.get(s-k) ;
            s += arr[i] ;

            map.put(s, i);
            if (i > 0 && pre[i - 1] != -1) {
                if (pre[i] == -1)
                    pre[i] = pre[i - 1];
                else
                    pre[i] = Math.min(pre[i], pre[i - 1]);
            }
        }

        int[] suf = new int[n] ;
        Arrays.fill(suf,-1) ;
        map.clear() ;
        map.put(0, n);
        s = 0 ;
        for(int i = n-1 ; i >= 0 ; i--){
            s += arr[i] ;
            if( map.containsKey(s-k) ) suf[i] = map.get(s - k) - i;
            
            map.put(s, i);
            if (i < n - 1 && suf[i + 1] != -1) {
            if (suf[i] == -1)
                suf[i] = suf[i + 1];
            else
                suf[i] = Math.min(suf[i], suf[i + 1]);
        }
        }
        int ans = Integer.MAX_VALUE ;
        for(int i = 0 ; i < n ; i++){
            if( pre[i] != -1 && suf[i] != -1 ) ans = Math.min(ans,pre[i] + suf[i]) ;
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }   
}