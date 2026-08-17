class Solution {
    boolean valid(int[] nums1, int[] nums2, int x) {
        int i = 0;
        int j = 0;
        int removed = 0;

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] + x == nums2[j]) {
                i++;
                j++;
            } else if (nums1[i] + x < nums2[j]) {
                i++;
                removed++;

                if (removed > 2)
                    return false;
            } else {
                return false;
            }
        }

        return true;
    }
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1) ;
        Arrays.sort(nums2) ;
        int ans = 0 ;
        for(int i = 0 ; i < 3 ; i++){
            if( valid(nums1,nums2,nums2[0]-nums1[i]) ){
                ans = nums2[0]-nums1[i] ;
            }
        }

        return ans ;
    }
}