class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }

        TreeMap<Integer,Integer> map = new TreeMap<>() ;
        
        for(int n : nums){
            if( !map.containsKey(n) ) map.put(n,0) ;
            map.put(n,map.get(n)+1);
        }

        int grp = nums.length/k ;
        for(int i = 0 ; i < grp ; i++){
            int st = map.firstKey() ;
            for(int j = st ; j < st+k ; j++){
                if( !map.containsKey(j) ) return false ;
                map.put(j,map.get(j)-1) ;
                if( map.get(j) == 0 ) map.remove(j) ;
            }

        }
        return true ;
    }
}