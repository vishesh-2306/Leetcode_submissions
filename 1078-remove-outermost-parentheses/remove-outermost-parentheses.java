class Solution {
    private String str(int l,int r,char[] arr){
        StringBuilder res = new StringBuilder() ;

        for(int i = l ; i <= r ; i++ ){
            res.append(arr[i]) ;
        }

        return res.toString() ;
    }
    public String removeOuterParentheses(String s) {
        char[] arr = s.toCharArray() ;

        int bal = 0 ;
        int l = 0 ; 
        StringBuilder ans = new StringBuilder() ;

        for(int r = 0 ; r < s.length() ; r++){
            if( arr[r] == '(' ) bal++ ;
            else if( arr[r] == ')' ) bal-- ;
            if( bal == 0 ){
                ans.append(str(l+1,r-1,arr)) ;
                l = r+1 ;
            }
        }

        return ans.toString() ;
    }
}