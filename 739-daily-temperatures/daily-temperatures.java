class Solution {
    public int[] dailyTemperatures(int[] temp) {
        
        Stack<Integer> s = new Stack<>() ;
        int[] ans = new int[temp.length] ;

        for(int i = 0 ; i < temp.length ; i++){
            while( !s.isEmpty() && temp[s.peek()] < temp[i] ){
                int idx = s.pop() ;
                ans[idx] = i-idx ;
            }

            s.push(i) ;
        }

        return ans ;
    }
}