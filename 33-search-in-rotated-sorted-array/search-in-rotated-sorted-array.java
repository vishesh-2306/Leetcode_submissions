class Solution {
    public int search(int[] nums, int tar) {
        int n = nums.length ;
        int l = 0 , r = n-1 ;

        while( l <= r){
            int mid = (l+r)/2 ;

            if( nums[mid] == tar ) return mid ;

            else if( nums[mid] >= nums[r] ){
                if( tar >= nums[l] && tar < nums[mid] ) r = mid-1 ;
                else l = mid+1 ;
            }else{
                if( tar > nums[mid] && tar <= nums[r] ) l = mid+1 ;
                else r = mid-1 ;
            }
        }

        return -1 ;
    }
}