class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length ;
        int l = 0 , r = n - 1 ;
        ArrayList<Integer> res = new ArrayList<>() ;

        while( r-l+1 > k){
            if( Math.abs(x-arr[l]) <= Math.abs(arr[r]-x) ) r-- ;
            else l++ ;
        }

        for(int i = l ; i <= r ; i++){
            res.add(arr[i]) ;
        }
        return res ;
        
    }
}