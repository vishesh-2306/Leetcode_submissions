class Solution {
    private void dfs(int node,ArrayList<Integer>[] graph,boolean[] suspicious) {

        if (suspicious[node]) {
            return;
        }

        suspicious[node] = true;

        for (int next : graph[node]) {
            dfs(next, graph, suspicious);
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invo) {

        ArrayList<Integer>[] graph = new ArrayList[n] ;

        for(int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<>() ;
        }

        for(int i = 0 ; i < invo.length ; i++){
            int u = invo[i][0] ;
            int v = invo[i][1] ;
            graph[u].add(v) ;
        }

        boolean[] suspicious = new boolean[n];
        dfs(k, graph, suspicious);

        boolean possible = true;

        for (int[] edge : invo) {
            int u = edge[0];
            int v = edge[1];

            if (!suspicious[u] && suspicious[v]) {
                possible = false;
                break;
            }
        }

        List<Integer> ans = new ArrayList<>();

        if (!possible) {
            for (int i = 0; i < n; i++) {
                ans.add(i);
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (!suspicious[i]) {
                    ans.add(i);
                }
            }
        }

        return ans;
    }
}