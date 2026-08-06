class Solution {
    long C(long x) {
        if (x < 2) {
            return 0;
        }
        return x * (x - 1) / 2;
    }
    public long distributeCandies(int n, int limit) {
        return C(n + 2)
                    - 3 * C(n - limit + 1)
                    + 3 * C(n - 2L * limit)
                    - C(n - 3L * limit - 1);
        
    }
}