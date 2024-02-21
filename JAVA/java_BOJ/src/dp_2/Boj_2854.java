package dp_2;

import java.io.*;

public class Boj_2854 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] problems = new long[n + 1];
        long[] ambiguousProblems = new long[n + 1];
        long[][] dp = new long[4][n + 1];

        String[] line1 = br.readLine().split(" ");
        String[] line2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            problems[i + 1] = Long.parseLong(line1[i]);
            if (i < n - 1)
                ambiguousProblems[i + 1] = Long.parseLong(line2[i]);
        }

        // dp[0][depth] : 변동 문제를 사용하지 않는 경우
        // dp[1][depth] : 변동 문제를 낮은 난이도로 사용하는 경우 (난이도가 3 또는 4인 문제가 5개 있다면 5개 모두 3으로 취급)
        // dp[2][depth] : 변동 문제를 높은 난이도로 사용하는 경우 (난이도가 3 또는 4인 문제가 5개 있다면 5개 모두 4으로 취급)
        // dp[3][depth] : 변동 문제만을 이용하여 사용하는 경우
        //                (난이도가 3 또는 4인 문제가 5개 있다면 난이도가 3, 4인 문제를 출제할 시 변동문제 5개만을 사용하여 문제를 출제)
        dp[0][0] = 1;

        dp[0][1] = problems[1];
        dp[1][1] = ambiguousProblems[1];

        for (int i = 2; i <= n; i++) {
            dp[0][i]
                    = ((dp[0][i - 1] + dp[1][i - 1] + dp[2][i - 1] + dp[3][i - 1]) * problems[i])
                    % 1_000_000_007;
            dp[1][i]
                    = ((dp[0][i - 1] + dp[1][i - 1] + dp[2][i - 1] + dp[3][i - 1]) * ambiguousProblems[i])
                    % 1_000_000_007;
            dp[2][i]
                    = ((dp[0][i - 1] + dp[2][i - 1] + dp[3][i - 1]) * ambiguousProblems[i - 1])
                    % 1_000_000_007;
            dp[3][i] = (
                    (dp[0][i - 2] + dp[1][i - 2] + dp[2][i - 2] + dp[3][i - 2])
                            * ((ambiguousProblems[i - 1] * (ambiguousProblems[i - 1] - 1)) % 1_000_000_007)
                    ) % 1_000_000_007;
            if (dp[3][i] < 0) dp[3][i] = 0;
        }

        System.out.println((dp[0][n] + dp[1][n] + dp[2][n] + dp[3][n]) % 1000000007);
    }
}
