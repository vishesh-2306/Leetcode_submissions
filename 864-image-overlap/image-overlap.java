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

        int[][] count = new int[2 * n - 1][2 * n - 1];
        int max = 0;

        for(int n1 : l1){

            int x1 = n1/n ;
            int y1 = n1%n ;

            for(int n2 : l2){

                int x2 = n2/n ;
                int y2 = n2%n ;

                int dx = x1 - x2 + n - 1;
                int dy = y1 - y2 + n - 1;

                count[dx][dy]++;
                max = Math.max(max, count[dx][dy]);
            }
        }

        return max ;
    }
}