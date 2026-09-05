class Solution {
    public int maximizeGreatness(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>() ;

        for(int x : nums){
            if( !map.containsKey(x) ) map.put(x,0) ;

            map.put(x,map.get(x)+1) ;
        }

        int cnt = 0 ;

        for(int x : nums){

            Integer ceil = map.higherKey(x) ;

            if( ceil != null ){
                int val = map.get(ceil) ;
                if( val == 1 ) map.remove(ceil) ;
                else map.put(ceil,val-1) ;
                cnt++ ;
            }
            
        }

        return cnt ;
    }
}