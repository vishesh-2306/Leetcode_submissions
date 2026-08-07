class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;


        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2] ) ;
        pq.offer(new int[]{0, 0, 0});

        int[][] cost = new int[m][n] ;
        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        cost[0][0] = 0;

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!pq.isEmpty()){
            int[] curr = pq.remove() ;
            int x = curr[0] ;
            int y = curr[1] ;
            int cst = curr[2] ;

            if( x == m-1 && y == n-1 ) return cst ;

            for(int i = 0 ; i < 4 ; i++){
                int nx = dir[i][0] + x ;
                int ny = dir[i][1] + y ;

                if( nx < 0 || nx >= m || ny < 0 || ny >= n ) continue ;

                int newCst = (grid[nx][ny] == 1 ) ? cst+1 : cst ;

                if( cost[nx][ny] > newCst ){
                    cost[nx][ny] = newCst ;
                    pq.add(new int[]{nx,ny,newCst}) ;
                }

            }

        }

        return 0 ;
    }
}