class Solution {
    public int[] resultArray(int[] nums) {
        int i = 2 ;
        ArrayList<Integer> l1 = new ArrayList<>() ;
        l1.add(nums[0]) ;
        ArrayList<Integer> l2 = new ArrayList<>() ;
        l2.add(nums[1]) ;

        while( i < nums.length ){
            if( l1.get(l1.size()-1) > l2.get(l2.size()-1) ) l1.add(nums[i]) ;
            else l2.add(nums[i]) ;
            i++ ;
        }

        l1.addAll(l2);

        int[] res = l1.stream().mapToInt(Integer::intValue).toArray();
        return res ;
    }
}