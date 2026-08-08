class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            dp[i] = dp[i + 1];

            if (dp[i + 1] < m) {

                int j = m - dp[i + 1] - 1;

                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i]++;
                }
            }
        }
        int[] ans = new int[m];

        int j = 0;              
        int prev = -1;
        boolean usedMismatch = false;

        for (int i = 0; i < n && j < m; i++) {

            
            if (i <= prev)
                continue;

            
            if (word1.charAt(i) == word2.charAt(j)) {

                ans[j] = i;
                prev = i;
                j++;
            }

            else if (!usedMismatch &&
                     dp[i + 1] >= m - j - 1) {

                ans[j] = i;
                prev = i;
                j++;
                usedMismatch = true;
            }
        }

        
        if (j < m) {
            return new int[0];
        }

        return ans;
    }
}