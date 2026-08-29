class Solution {
    public String makeLargestSpecial(String s) {
        ArrayList<String> parts = new ArrayList<>() ;

        int st = 0 ;
        int bal = 0 ;

        for(int i = 0 ; i < s.length() ; i++){
            if( s.charAt(i) == '1' ) bal++ ;
            else bal-- ;

            if( bal == 0 ) {
                String inside = s.substring(st+1,i) ;

                String best = makeLargestSpecial(inside) ;

                String part = "1" + best + "0" ;

                parts.add(part) ;
                st = i + 1 ;
            }

        }

        Collections.sort(parts,Collections.reverseOrder()) ;
        StringBuilder sb = new StringBuilder() ;

        for(String part : parts){
            sb.append(part) ;
        }

        return sb.toString() ;
    }
}