class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0L ;

        for(int x : nums) sum += x ;

        int target = (int)(sum % p);
        if( target == 0 ) return target ;

        HashMap<Integer,Integer> map = new HashMap<>() ;
        map.put(0, -1);

        int pre = 0 ;
        int remove = nums.length ;
        for(int i = 0 ; i < nums.length ; i++){
            pre = (pre + nums[i]) % p;

            int need = (pre - target + p) % p;
            if( map.containsKey(need)) remove = Math.min(i-map.get(need),remove) ;

            map.put(pre,i) ;
        }

        return (remove == nums.length ) ? -1 : remove ;
    }
}