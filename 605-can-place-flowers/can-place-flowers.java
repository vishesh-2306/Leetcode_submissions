class Solution {
    public boolean canPlaceFlowers(int[] fb, int n) {
        int l = fb.length ;

        if( l == 1 ) return (n == 0 || fb[0] == 0) ;

        if(fb[0] == 0  && fb[1] == 0) {
            fb[0] = 1 ;
            n-- ;
        } 

        if(fb[l-1] == 0  && fb[l-2] == 0){
            fb[l-1] = 1 ;
            n-- ;
        } 


        for(int i = 1 ; i < l-1 ; i++){

            if( fb[i] == 0 && fb[i-1] == 0 && fb[i+1] == 0 ) {
                fb[i] = 1 ;
                n-- ;
            }
        }

        return (n <= 0 ) ;
    }
}