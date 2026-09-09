class Solution {
    public long countCommas(long n) {

        long cnt = 0;
        long start = 1_000;
        long commas = 1;

        while (start <= n) {
            long next = start * 1000;

            if (next < 0 || next > n) {
                cnt += commas * (n - start + 1);
                break;
            }

            cnt += commas * (next - start);

            start = next;
            commas++;
        }

        return cnt;
    }
}