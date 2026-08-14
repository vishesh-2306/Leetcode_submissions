class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> set = new HashSet<>() ;
        set.add('a') ;
        set.add('e') ;
        set.add('i') ;
        set.add('o') ;
        set.add('u') ;

        int l = 0 ;
        int cnt = 0 ;
        int ans = 0 ;
        for(int r = 0 ; r < s.length() ; r++){
            if( set.contains(s.charAt(r)) ) cnt++ ;

            while(r-l+1 > k){
                if( set.contains(s.charAt(l)) ) cnt-- ;
                l++ ;
            }

            ans = Math.max(cnt,ans) ;
        }

        return ans ;
    }
}