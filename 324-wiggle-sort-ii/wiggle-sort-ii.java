class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length ;
        int[] arr = nums.clone() ;
        Arrays.sort(arr) ;

        int l = (n-1)/2 ;
        int r = n-1 ;

        for(int i=0;i<n;i+=2){ 
            nums[i]= arr[l];
            l--;
        }
        for(int i=1;i<n;i+=2){
            nums[i]= arr[r];
            r--;
        }

    }
}