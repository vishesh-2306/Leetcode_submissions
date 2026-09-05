class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int max = 0 ;
        Deque<Integer> q = new ArrayDeque<>() ;
        for(int i = 0 ; i < nums.length ; i++){
            while( !q.isEmpty() && nums[q.peekLast()] > nums[i] ) q.pollLast() ;

            q.addLast(i) ;

        }

        for(int i = 0 ; i < nums.length ; i++){
            max = Math.max(nums[i],max) ;
            while (!q.isEmpty() && q.peekFirst() < i) {
                q.pollFirst();
            }
            
            if( max - nums[q.peek()] <= k ) return i ;
            
        }

        return -1 ;
    }
}