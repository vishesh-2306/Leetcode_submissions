class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        

        int l = 0 ;
        int ans = 0 ;
        HashMap<Integer,Integer> map = new HashMap<>() ;

        for(int r = 0 ; r < nums.length ; r++){
            int n = nums[r] ;
            map.put(n,map.getOrDefault(n,0)+1) ;
            

            while( map.get(n) > k ){
                map.put(nums[l],map.get(nums[l])-1) ;
                if( map.get(nums[l]) == 0 ) map.remove(nums[l]) ;
                l++ ;
            }

            ans = Math.max(ans,r-l+1) ;
        }

        return ans ;
    }
}