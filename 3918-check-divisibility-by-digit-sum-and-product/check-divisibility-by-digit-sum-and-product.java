class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0 ;
        int prod = 1 ;
        int temp = n ;
        while(temp > 0 ){
            int dig = temp%10 ;
            sum += dig ;
            prod *= dig ;
            temp /= 10 ;
        }

        return (n%(sum+prod) == 0 ) ;
    }
}