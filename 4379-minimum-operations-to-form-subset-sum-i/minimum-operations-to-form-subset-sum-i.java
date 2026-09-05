class Solution {
    public int minOperations(int[] a, int sum) {
        int n = a.length;

        long[][][] dp = new long[n + 1][sum + 1][2];

        dp[0][0][0] = 1; // possible
        dp[0][0][1] = 0; // operations

        for (int i = 1; i <= n; i++) {
            dp[i][0][0] = 1;
            dp[i][0][1] = 0;

            for (int j = 1; j <= sum; j++) {

                long answer = 0;
                long op = Long.MAX_VALUE;

                
                answer = dp[i - 1][j][0];

                if (answer == 1) {
                    op = dp[i - 1][j][1];
                }

                int number = a[i - 1];

                
                if (j - number >= 0) {
                    answer = Math.max(answer,dp[i - 1][(j - number)][0]);

                    if (dp[i - 1][(j - number)][0] == 1) {
                        op = Math.min(op,dp[i - 1][(int)(j - number)][1]);
                    }
                }

                // Multiply by 2, 4, 8, ...
                long number1 = 2 * number;
                long g = 1;

                while (number1 <= j) {

                    answer = Math.max(
                        answer,
                        dp[i - 1][(int)(j - number1)][0]
                    );

                    if (dp[i - 1][(int)(j - number1)][0] == 1) {
                        op = Math.min(
                            op,
                            g + dp[i - 1][(int)(j - number1)][1]
                        );
                    }

                    number1 = 2 * number1;
                    g++;
                }

                // Divide by 2, 4, 8, ...
                long number2 = number / 2;
                g = 1;

                while (number2 >= 1) {

                    if (j - number2 >= 0) {

                        answer = Math.max(
                            answer,
                            dp[i - 1][(int)(j - number2)][0]
                        );

                        if (dp[i - 1][(int)(j - number2)][0] == 1) {
                            op = Math.min(
                                op,
                                g + dp[i - 1][(int)(j - number2)][1]
                            );
                        }
                    }

                    number2 = number2 / 2;
                    g++;
                }

                dp[i][j][0] = answer;
                dp[i][j][1] = op;
            }
        }

        if (dp[n][(int)sum][0] == 1) {
            return (int) dp[n][sum][1];
        }

        return -1;
    }
}