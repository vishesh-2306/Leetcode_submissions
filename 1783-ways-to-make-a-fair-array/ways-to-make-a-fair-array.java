class Solution {
    public int waysToMakeFair(int[] nums) {
        long totEven = 0;
        long totOdd = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                totEven += nums[i];
            } else {
                totOdd += nums[i];
            }
        }

        long leftEven = 0;
        long leftOdd = 0;

        int cnt = 0;

        for(int i = 0 ; i < nums.length ; i++){

            long rightEven = totEven - leftEven;
            long rightOdd = totOdd - leftOdd;

            if( i%2 == 0){
                rightEven -= nums[i];
            } else{
                rightOdd -= nums[i] ;
            }

            long newEven = leftEven + rightOdd ;
            long newOdd = leftOdd + rightEven;

            if( newEven == newOdd ) cnt++ ;
            leftEven += (i%2 == 0 ) ? nums[i] : 0 ;
            leftOdd += (i%2 == 1 ) ? nums[i] : 0 ;
        }


        return cnt ;
    }
}