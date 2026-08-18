class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length ;
        int ans = -1 ;
        if(k == n){
            for(int x : nums ){
                ans = Math.max(ans,x) ;
            }
            return ans ;
        }
        TreeMap<Integer,Integer> map = new TreeMap<>() ;

        for(int i = 0 ; i < n ; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1) ;
        }
        
        if( k == 1 ){
            
            for(int x : map.keySet() ){
                if( map.get(x) == 1) ans = x ;
            }
            return ans ;
        }
        int l = (map.get(nums[0]) == 1) ? nums[0] : Integer.MIN_VALUE ;
        int r = (map.get(nums[n-1]) == 1) ? nums[n-1] : Integer.MIN_VALUE ;

        ans = Math.max(ans,Math.max(l,r)) ;

        return ans ;
    }
}