class Solution {
    public long dfs(int node,ArrayList<Integer>[] list,int[] par, int[] nums,int ht,int depth){
        
        long sum = 0L ;
        for(int x : list[node] ){
            sum += dfs(x,list,par,nums,ht,depth+1) ;
        }

        return sum + 1L*nums[node]*(ht-depth+1) ;
    }
    public int getHeight(int root,ArrayList<Integer>[] list){

        int ht = 1 ;
        for(int x : list[root] ){
            ht = Math.max(ht, 1 + getHeight(x, list));
        }

        return ht ;
    }
    public long weightedSum(int[] par, int[] nums) {
        int n = par.length ;
        ArrayList<Integer>[] list = new ArrayList[n] ;
        for(int i = 0 ; i < n ; i++){
            list[i] = new ArrayList<>() ;
        }

        for(int i = 1 ; i < n ; i++){
            list[par[i]].add(i) ;
        }
        int h = getHeight(0,list) ;
        System.out.println(h) ;
        
        return dfs(0,list,par,nums,h,1)  ;
    }
}