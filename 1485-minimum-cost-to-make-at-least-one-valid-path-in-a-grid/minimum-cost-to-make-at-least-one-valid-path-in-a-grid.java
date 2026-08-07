class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;

        boolean[][] vist = new boolean[m][n] ;
        int[][] dist = new int[m][n] ;
        for(int i = 0 ; i < m ; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE) ;
        }
        dist[0][0] = 0 ;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2])) ;
        pq.add(new int[]{0,0,0}) ;

        int[] dx = {0,0,1,-1} ;
        int[] dy = {1,-1,0,0} ;

        while( !pq.isEmpty() ){
            int[] curr = pq.remove() ;
            int x = curr[0] ;
            int y = curr[1] ;
            int minCost = curr[2] ;

            if (vist[x][y])
            continue;

            vist[x][y] = true;

            if( x == m-1 && y == n-1 ) return minCost ;

            for(int k = 0 ; k < 4 ; k++){
                int nx = dx[k] + x ;
                int ny = dy[k] + y ;

                int wt = (k + 1 == grid[x][y]) ? 0 : 1 ;
                
                if( nx < 0 || nx >= m || ny < 0 || ny >= n ) continue ;

                if( minCost + wt < dist[nx][ny] ){
                    pq.add(new int[]{nx,ny,minCost+wt}) ;
                    dist[nx][ny] = minCost+wt ; 
                }
                

            }
        }

        return dist[m-1][n-1] ;
    }
}