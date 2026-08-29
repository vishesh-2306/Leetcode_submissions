class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length ;

        Arrays.sort(costs,(a,b)-> Integer.compare(a[0]-a[1],b[0]-b[1])) ;
        int sum = 0 ;

        for(int i = 0 ; i < n/2 ; i++){
            sum += costs[i][0] + costs[i+n/2][1] ;
        }

        return sum ;
    }
}