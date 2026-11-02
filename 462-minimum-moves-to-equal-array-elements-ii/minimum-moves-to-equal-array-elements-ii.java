class Solution {
    public int minMoves2(int[] nums) {
        int sum = 0 ;
        int n = nums.length ;
        

        Arrays.sort(nums) ;
        int med = 0 ;
        if( n%2 != 0 ) med = nums[n/2] ;
        else med = nums[(n+1)/2] ;
        
        int ans = 0 ;
        for(int i = 0 ; i < n ; i++){
            ans += Math.abs(nums[i]-med) ;
        }
        return ans ;
    }
}