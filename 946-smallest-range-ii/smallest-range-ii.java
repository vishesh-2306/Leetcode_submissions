class Solution {
    public int smallestRangeII(int[] nums, int k) {
        int n = nums.length ;
        if( n == 1 ) return 0 ;

        Arrays.sort(nums) ;
        
        int diff = nums[n-1] - nums[0] ;
        for(int i = 0 ; i < n-1 ; i++){
            int max = Math.max(nums[i]+k,nums[n-1]-k) ;
            int min = Math.min(nums[i+1]-k,nums[0]+k) ;


            diff = Math.min(diff,max-min) ;
        }

        return diff ;
    }
}