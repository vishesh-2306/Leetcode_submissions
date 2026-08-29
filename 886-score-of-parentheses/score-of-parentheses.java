class Solution {
    public int scoreOfParentheses(String s) {
        if( s.equals("") ) return 0 ;
        int st = 0 ;
        
        
        if( s.charAt(0) == '(' && s.charAt(1) == ')' ) {
            String sub = s.substring(2,s.length()) ;
            return 1 + scoreOfParentheses(sub) ;
        }
        else {
            int end = st ;
            int bal = 0 ;
            int score = 0 ;

            while(end < s.length() ){
                if( s.charAt(end) == '(' ) bal++ ;
                else bal-- ;

                if( bal == 0 ){
                    String sub = s.substring(st+1,end) ;
                    score += 2*scoreOfParentheses(sub) ;
                    break ;
                }
                end++ ;
            }
            

            return score + scoreOfParentheses(s.substring(end+1,s.length())) ;
        }
        
    }
}