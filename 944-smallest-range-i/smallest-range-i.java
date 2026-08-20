class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int n = nums.length ;
        if( n == 1 ) return 0 ;

        Arrays.sort(nums) ;
        
        int max = nums[n-1] ;
        int min = nums[0] ;
        

        return Math.max(max-min-2*k,0) ;
    }
}