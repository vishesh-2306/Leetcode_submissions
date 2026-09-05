class Solution {
    public int miceAndCheese(int[] r1, int[] r2, int k) {
        long sum = 0 ;

        for(int x : r2){
            sum += x ;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>() ;

        for(int i = 0 ; i < r1.length ; i++){
            pq.add(r2[i]-r1[i]) ;
        }
        while(k-- > 0){
            int num = pq.poll() ;
            sum -= num ;
        }

        return (int) sum ;

    }
}