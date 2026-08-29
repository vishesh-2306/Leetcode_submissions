class Solution {
    private int solve(int i,int[] nums,int st,int end){
        if( i == 4 ) return nums[end] - nums[st] ;

        return Math.min(solve(i+1,nums,st+1,end),solve(i+1,nums,st,end-1)) ;
    }
    public int minDifference(int[] nums) {
        int n = nums.length ;
        if( n <= 3 ) return 0 ;

        Arrays.sort(nums) ;
        return solve(1,nums,0,n-1) ;
    }
}