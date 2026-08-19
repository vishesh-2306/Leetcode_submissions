class Solution {
    public int maxNumberOfFamilies(int n, int[][] res) {
        

        HashMap<Integer,TreeSet<Integer>> map = new HashMap<>() ;
        Set<Integer> s1 = new HashSet<>(Arrays.asList(2, 3, 4, 5));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(4, 5, 6, 7));
        Set<Integer> s3 = new HashSet<>(Arrays.asList(6, 7, 8, 9));

        for(int[] r : res){
            map.putIfAbsent(r[0],new TreeSet<>()) ;

            map.get(r[0]).add(r[1]) ;
        }

        int ans = 0 ;
        for(Map.Entry<Integer,TreeSet<Integer>> entry : map.entrySet()){
            boolean grp1 = false ;
            boolean grp2 = false ;
            boolean grp3 = false ;

            for(int x : entry.getValue() ){
                if( s1.contains(x) ) grp1 = true ;
                if( s2.contains(x) ) grp2 = true ;
                if( s3.contains(x) ) grp3 = true ;
            }

            if( !grp1 && !grp2 && !grp3 ) ans += 2 ;
            else if( grp1 && grp2 && grp3  ) ans += 0 ;
            else ans += 1 ;
        }

        ans += (n-map.size())*2 ;
        return ans ;
    }
}