class Solution {
    public int minStoneSum(int[] nums, int k) {
        long sum = 0 ;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()) ;

        for(int i = 0 ; i < nums.length ; i++){
            pq.add(nums[i]) ;
            sum += nums[i] ;
        }

        while( k-- > 0){
            int num = pq.poll() ;

            sum -= num ;

            int x = (num+1)/2 ;
            pq.add(x) ;

            sum += x ;
        }

        return (int) sum ;
    }
}