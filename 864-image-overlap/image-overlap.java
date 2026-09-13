class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length ;
        ArrayList<Integer> l1 = new ArrayList<>() ;
        ArrayList<Integer> l2 = new ArrayList<>() ;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if( img1[i][j] == 1 ) l1.add(i*n+j) ;
                if( img2[i][j] == 1 ) l2.add(i*n+j) ;
            }
        }

        HashMap<String,Integer> map = new HashMap<>() ;
        int max = 0 ;
        for(int i = 0 ; i < l1.size() ; i++){
            for(int j = 0 ; j < l2.size() ; j++){
                int n1 = l1.get(i) ;
                int x1 = n1/n ;
                int y1 = n1%n ;

                int n2 = l2.get(j) ;
                int x2 = n2/n ;
                int y2 = n2%n ;

                String key = (x1-x2) + " " + (y1-y2) ;
                map.put(key,map.getOrDefault(key,0)+1) ;
                max = Math.max(map.get(key),max) ;
            }
        }

        return max ;
    }
}