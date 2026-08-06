class Solution {
    public int distributeCandies(int n, int limit) {
        int ways = 0 ;

        for(int i = 0 ; i <= limit && i <= n; i++){
            for(int j = 0 ; j <= limit && i+j <= n ; j++){
                for(int z = n-i-j ; z <= limit && i+j+z == n ; z++){
                    
                    ways++ ;
                }
            }
        }

        return ways ;
    }
}