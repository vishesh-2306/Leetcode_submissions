class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>() ;

        int res = 0 ;
        for(int i = 0 ; i < arr.length ; i++){
            int diff = ((arr[i] % k) + k) % k;

            if( map.containsKey( (k-diff)%k ) ){
                res += 1 ;
                map.put((k-diff)%k,map.get((k-diff)%k)-1) ; 
                if( map.get((k-diff)%k) == 0 ) map.remove((k-diff)%k) ;
            }else{

                if ( !map.containsKey(diff) ) map.put(diff,0) ;
                map.put(diff,map.get(diff)+1) ; 
            }
        }

        return (res == arr.length/2) ;
    }
}