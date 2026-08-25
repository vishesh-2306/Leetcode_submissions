class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>() ;

        for(int x : nums) set.add(x) ;

        for(int i = 1 ; i <= 200 ; i++){
            if( i % k == 0 && !set.contains(i) ) return i ;
        }

        return 0 ;
    }
}