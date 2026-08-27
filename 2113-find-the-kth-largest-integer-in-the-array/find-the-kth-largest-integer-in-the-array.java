class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> {
            if( a.length() != b.length() ) return Integer.compare(a.length(),b.length()) ;
            return a.compareTo(b) ;
        }) ;

        for(int i = 0 ; i < nums.length ; i++){
            pq.add(nums[i]) ;

            if( pq.size() > k ) pq.poll() ;

        }

        return pq.peek() ;
    }
}