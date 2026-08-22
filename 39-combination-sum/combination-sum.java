class Solution {
    private void dfs(int i ,int[] cand, int target,List<Integer> temp,List<List<Integer>> res){
        
        if( target == 0 ){
            res.add(new ArrayList<>(temp));
            return ;
        }
        if( i == cand.length || target < 0 ) return ;

        temp.add(cand[i]) ;
        dfs(i,cand,target-cand[i],temp,res) ;
        temp.remove(temp.size()-1) ;
        dfs(i+1,cand,target,temp,res) ;
        
        return ;
    }

    
    
    public List<List<Integer>> combinationSum(int[] cand, int target) {
        List<List<Integer>> res = new ArrayList<>() ;
        List<Integer> temp = new ArrayList<>() ;

        dfs(0,cand,target,temp,res) ;
        return res ;
    }
}