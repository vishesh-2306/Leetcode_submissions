class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length ;
        ArrayList<Integer> tails = new ArrayList<>() ;
        tails.add(nums[0]) ;

        for(int x : nums ){
            if( tails.get(tails.size()-1) < x ) tails.add(x) ;
            else{
                int l = 0, r = tails.size() - 1;

                while (l < r) {
                    int mid = l + (r - l) / 2;

                    if (tails.get(mid) >= x) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }

                tails.set(l,x) ;
            }
        }

        return tails.size() ;
    }
}