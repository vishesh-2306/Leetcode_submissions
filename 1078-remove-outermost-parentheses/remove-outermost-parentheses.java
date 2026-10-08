class Solution {
    
    public String removeOuterParentheses(String s) {
        char[] arr = s.toCharArray() ;

        int bal = 0 ;
        int l = 0 ; 
        StringBuilder ans = new StringBuilder() ;

        for(int r = 0 ; r < s.length() ; r++){
            if( arr[r] == '(' ) bal++ ;
            else if( arr[r] == ')' ) bal-- ;
            if( bal == 0 ){
                ans.append(s.substring(l+1,r)) ;
                l = r+1 ;
            }
        }

        return ans.toString() ;
    }
}