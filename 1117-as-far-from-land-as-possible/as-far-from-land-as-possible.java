class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length ;

        boolean[][] vist = new boolean[n][n] ;
        int[][] dist = new int[n][n] ;

        Queue<int[]> q = new LinkedList<>() ;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if( grid[i][j] == 1 ) {
                    dist[i][j] = 0 ;
                    q.add(new int[]{i,j,0}) ;
                    vist[i][j] = true ;
                }
            }
        }

        int[] dx = {-1,1,0,0} ;
        int[] dy = {0,0,-1,1} ;
        int max = 0 ;

        while( !q.isEmpty() ){
            int[] curr = q.remove() ;

            for(int k = 0 ; k < 4 ; k++){
                int nx = dx[k] + curr[0] ;
                int ny = dy[k] + curr[1] ;
                if( nx < 0 || nx >= n || ny < 0 || ny >= n || vist[nx][ny] ) continue ;

                if( grid[nx][ny] == 1 ) continue ;
                
                vist[nx][ny] = true ;
                q.add(new int[]{nx,ny,curr[2]+1}) ;
                dist[nx][ny] = curr[2]+1 ;
                max = Math.max(max,dist[nx][ny]) ;
            }
            
        }
        if( max == 0 ) return -1 ;
        return  max ;

    }
}