class Solution {
    public int dfs(int node,int par,ArrayList<int[]>[] graph){
        int cost =  0;

        for(int[] x : graph[node] ){
            if( x[0] == par ) continue ;
            
            cost += x[1] + dfs(x[0],node,graph) ;
        }

        return cost ;
    }
    public int minReorder(int n, int[][] con) {
        ArrayList<int[]>[] graph = new ArrayList[n] ;

        for(int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<>() ;
        }

        for(int[] c : con){
            int u = c[0] ;
            int v = c[1] ;

            graph[u].add(new int[]{v,1}) ;
            graph[v].add(new int[]{u,0}) ;
        }

        return dfs(0,-1,graph) ;
    }
}