class Solution {
    public int dfs(int node,int par,ArrayList<int[]>[] graph){
        int cst = 0 ;

        for(int[] x : graph[node] ){
            if( x[0] == par ) continue ;

            cst += x[1] ;
            cst += dfs(x[0],node,graph) ;
        }

        return cst ;
    }
    public int[] minEdgeReversals(int n, int[][] edges) {
        ArrayList<int[]>[] graph = new ArrayList[n] ;

        for(int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<>() ;
        }

        for(int[] c : edges){
            int u = c[0] ;
            int v = c[1] ;

            graph[u].add(new int[]{v,0}) ;
            graph[v].add(new int[]{u,1}) ;
        }

        int[] cost = new int[n] ;
        cost[0] = dfs(0,-1,graph) ;

        Queue<int[]> q = new LinkedList<>() ;
        q.offer(new int[]{0,-1}) ;

        while( !q.isEmpty() ){
            int[] node = q.poll() ;
            int par = node[0] ;
            int parpar = node[1] ;

            for(int[] edge : graph[par] ){
                int child = edge[0] ;
                if( child == parpar ) continue ;
                int cst = edge[1] ;
                cost[child] = cost[par] + 1 - 2*cst ;
                q.offer(new int[]{child,par}) ;
            }
        }

        return cost ;
    }
}