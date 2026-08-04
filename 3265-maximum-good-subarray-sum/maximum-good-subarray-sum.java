class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Long, Long> map = new HashMap<>();
        int len = nums.length ;

        long ans = Long.MIN_VALUE ;
        long sum = 0 ;

        for(int i = 0 ; i < len ; i++){
            long n = nums[i] ;

            sum += n ;
            if( map.containsKey(n+k) ) ans = Math.max(ans,sum - map.get(n+k)) ;
            if( map.containsKey(n-k) ) ans = Math.max(ans,sum - map.get(n-k)) ;

            long min = Long.MAX_VALUE ;
            if( map.containsKey(n) )  min = map.get(n) ;

            map.put(n,Math.min(sum-n,min)) ;
        }

        return ans == Long.MIN_VALUE ? 0 : ans;
    }
}