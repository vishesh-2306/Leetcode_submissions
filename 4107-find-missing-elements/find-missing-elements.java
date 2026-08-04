class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE ;
        int max = Integer.MIN_VALUE ;
        int n = nums.length ;
        HashSet<Integer> set = new HashSet<>() ;

        for(int i = 0 ; i < n ; i++){
            min = Math.min(min,nums[i]) ;
            max = Math.max(max,nums[i]) ;
            set.add(nums[i]) ;
        }

        List<Integer> res = new ArrayList<>() ;
        for(int i = min ; i <= max ; i++){
            if( !set.contains(i) ) {
                res.add(i) ;
            }
            
        }

        return res ;
    }
}