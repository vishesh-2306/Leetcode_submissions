class Solution {
    public int minCost(String colors, int[] nT) {
        int ans = 0 ;
        int max = nT[0] ;

        for(int i = 1 ; i < colors.length() ; i++){

            if( colors.charAt(i) == colors.charAt(i-1) ){
                ans += Math.min(max,nT[i]) ;
                max = Math.max(nT[i],max) ;
            }else{
                max = nT[i] ;
            }

        }

        return ans ;
    }
}