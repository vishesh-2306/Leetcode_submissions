class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length ;
        int[][] dp = new int[n][2] ;

        

        if(nums[0] > 0 ) dp[0][0] = 1 ;
        else if(nums[0] < 0 ) dp[0][1] = 1 ;
        int ans = dp[0][0];

        for(int i = 1 ; i < n ; i++){
            if( nums[i] == 0 ){
                continue ;
            }
            else if(nums[i] > 0) {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] == 0 ? 0 : dp[i - 1][1] + 1;
            }
            else {
                dp[i][0] = dp[i - 1][1] == 0 ? 0 : dp[i - 1][1] + 1;
                dp[i][1] = dp[i - 1][0] + 1;
            }
            ans = Math.max(dp[i][0],ans) ;
        }

        return ans ;
    }
}