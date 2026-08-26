class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int cnt = 0 ;
        
        HashMap<Integer,Integer> map = new HashMap<>() ;
        map.put(0,-1) ;

        String ans = "" ;
        int minLen = Integer.MAX_VALUE;
        
        for(int r = 0 ; r < s.length() ; r++){

            if( s.charAt(r) == '1' ) cnt++ ;

            if (map.containsKey(cnt - k)) {
                int l = map.get(cnt - k);

                String curr = s.substring(l + 1, r + 1);

                if (curr.length() < minLen) {
                    ans = curr;
                    minLen = curr.length();
                } 
                else if (curr.length() == minLen && curr.compareTo(ans) < 0) {
                    ans = curr;
                }
            }

            
            map.put(cnt,r) ;
        }

        return ans ;

    }
}