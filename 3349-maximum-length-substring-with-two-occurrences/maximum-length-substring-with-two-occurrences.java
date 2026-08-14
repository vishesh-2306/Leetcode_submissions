class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>() ;
        int l = 0 ;
        int size = 0 ;

        for(int r = 0 ; r < s.length() ; r++){
            char ch = s.charAt(r) ;
    
            map.put(ch,map.getOrDefault(ch,0)+1) ;

            while(map.get(ch) > 2){
                char t = s.charAt(l) ;
                map.put(t,map.get(t)-1) ;
                if( map.get(t) == 0 ) map.remove(t) ;
                l++ ;
            }

            size = Math.max(size,r-l+1) ;
        }

        return size ;
    }
}