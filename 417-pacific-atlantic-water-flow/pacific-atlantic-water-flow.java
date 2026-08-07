class Solution {
    public void dfs(int[][] ht, boolean[][] vist,int i,int j,int prevht){
        int m = ht.length ;
        int n = ht[0].length ;
        if( i < 0 || j < 0 || i >= m || j >= n || vist[i][j] || ht[i][j] < prevht ) return ;

        vist[i][j] = true ;
        dfs(ht,vist,i+1,j,ht[i][j]) ;
        dfs(ht,vist,i-1,j,ht[i][j]) ;
        dfs(ht,vist,i,j+1,ht[i][j]) ;
        dfs(ht,vist,i,j-1,ht[i][j]) ;
        return ;
    }
    public List<List<Integer>> pacificAtlantic(int[][] ht) {
        int m = ht.length ;
        int n = ht[0].length ;

        boolean vistPac[][] = new boolean[m][n] ;
        boolean vistAt[][] = new boolean[m][n] ;
        boolean res[][] = new boolean[m][n] ;
        

        for(int j = 0 ; j < n ; j++){
            dfs(ht,vistPac,0,j,Integer.MIN_VALUE) ;
        }
        for (int i = 0; i < m; i++) dfs(ht, vistPac, i, 0, Integer.MIN_VALUE);
        for(int j = 0 ; j < n ; j++){
            dfs(ht,vistAt,m-1,j,Integer.MIN_VALUE) ;
        }
        for (int i = 0; i < m; i++) dfs(ht, vistAt, i, n - 1, Integer.MIN_VALUE);

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if( vistPac[i][j] && vistAt[i][j] ){
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result ;
         
    }
}