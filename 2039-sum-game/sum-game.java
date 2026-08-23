class Solution {
    public boolean sumGame(String num) {
        int lsum = 0 , rsum = 0 ;
        int lq = 0 , rq = 0 ;

        char[] ch = num.toCharArray() ;
        int n = ch.length ;
        for(int i = 0 ; i < n/2 ; i++){
            if( ch[i] == '?' ) lq++ ;
            else{
                lsum += (int) (ch[i]-'0') ;
            }
        }

        for(int i = n/2 ; i < n ; i++){
            if( ch[i] == '?' ) rq++ ;
            else{
                rsum += (int) (ch[i]-'0') ;
            }
        }

        if( (lq+rq) % 2 == 1 ) return true ;

        return ( 2*lsum + 9*lq == 2*rsum + 9*rq ) ? false : true  ;
    }
}