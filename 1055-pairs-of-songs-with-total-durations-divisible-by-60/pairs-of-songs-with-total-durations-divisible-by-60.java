class Solution {
    public int numPairsDivisibleBy60(int[] time){
        HashMap<Integer,Integer> map = new HashMap<>() ;

        int res = 0 ;
        for(int i = 0 ; i < time.length ; i++){
            int diff = time[i]%60 ;

            res += map.getOrDefault((60-diff)%60,0) ;
            if( !map.containsKey(diff) ) map.put(diff,0) ;
            map.put(diff,map.get(diff)+1) ;
        }

        return res ;
    }
}