class Solution {
    public int minMoves(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>() ;

        for(int n: nums){
            map.putIfAbsent(n,0) ;
            map.put(n,map.get(n)+1) ;
        }

        int l = map.size() ;
        int ans = 0 ;
        int first = map.firstKey() ;
        for(int i = 0 ; i < l-1 ; i++){
            int last = map.lastKey()  ;
            ans += map.get(last)*(last-first) ;
            map.remove(last) ;
        }

        return ans ;
    }
}