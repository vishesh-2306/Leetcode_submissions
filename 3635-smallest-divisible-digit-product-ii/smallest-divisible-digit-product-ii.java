class Solution {
    private long gcd(long a, long b) { return b == 0 ? a : gcd(b, a % b); }

    public String smallestNumber(String num, long t) {
        long temp = t;
        for (int i = 2; i <= 9; i++) {
            while (temp % i == 0) temp /= i;
        }
        if (temp > 1) return "-1";
        int n = num.length();
        long[] rem = new long[n + 1];
        rem[0] = t;
        int pos = n - 1;
        char[] numArr = num.toCharArray();
        for (int i = 0; i < n; i++) {
            if (numArr[i] == '0') {
                pos = i; break;
            }
            rem[i + 1] = rem[i] / gcd(rem[i], numArr[i] - '0');
        }
        if (rem[n] == 1 && pos == n - 1 && numArr[pos] != '0') return num;
        for (int i = pos; i >= 0; i--) {
            int startDigit = (i < n) ? (numArr[i] - '0') + 1 : 1;
            for (int d = startDigit; d <= 9; d++) {
                long tNow = rem[i] / gcd(rem[i], d);
                StringBuilder suffix = new StringBuilder();
                long currT = tNow;
                for (int j = n - 1; j > i; j--) {
                    for (int v = 9; v >= 1; v--) {
                        if (currT % v == 0) {
                            suffix.append(v);
                            currT /= v; break;
                        }
                    }
                }
                if (currT == 1) {
                    StringBuilder ans = new StringBuilder();
                    for (int k = 0; k < i; k++) ans.append(numArr[k]);
                    ans.append(d).append(suffix.reverse());
                    return ans.toString();
                }
            }
        }
        long currT = t;
        List<Integer> digits = new ArrayList<>();
        for (int v = 9; v >= 2; v--) {
            while (currT % v == 0) {
                digits.add(v); currT /= v;
            }
        }
        Collections.sort(digits);
        int reqLen = Math.max(n + 1, digits.size());
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < reqLen - digits.size(); i++) ans.append("1");
        for (int d : digits) ans.append(d);
        return ans.toString();
    }
}