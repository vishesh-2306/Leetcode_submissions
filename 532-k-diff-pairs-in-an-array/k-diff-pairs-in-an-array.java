class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>() ;
        int cnt = 0 ;

        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1) ;
        }

        if( k == 0 ){

            for (int x : map.keySet()) {
                if( map.get(x) > 1 ) cnt++ ;
            }

        } else{

            for (int x : map.keySet() ){
                if (map.containsKey(x + k)) {
                    cnt++;
                }
            }

        }
        return cnt ;
    }
}