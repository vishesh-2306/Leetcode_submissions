class Solution {
    void dfs(int node, int parent, ArrayList<Integer>[] tree,
         int[] size, int[] ans) {

        for (int child : tree[node]) {

            if (child == parent) continue;

            dfs(child, node, tree, size, ans);

            size[node] += size[child];
            ans[0] += size[child];
        }
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ArrayList<Integer>[] tree = new ArrayList[n] ;
        int[] size = new int[n] ;

        for(int i = 0; i < n; i++){
            tree[i] = new ArrayList<>();
            size[i] = 1 ;
        }

        for(int[] edge : edges){
            int u = edge[0] ;
            int v = edge[1] ;

            tree[u].add(v) ;
            tree[v].add(u);
        }

        int[] ans = new int[n] ;
        dfs(0, -1, tree, size, ans);
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        Queue<Integer> q = new ArrayDeque<>() ;
        q.add(0);
        parent[0] = -2;

        while( !q.isEmpty() ){
            int curr = q.poll() ;

            for(int x : tree[curr] ){
                if (x == parent[curr]) continue;
                ans[x] = ans[curr] + (n-size[x]) - size[x] ;

                parent[x] = curr;
                q.add(x) ;
            }
        }
        
        
        return ans ;
    }
}