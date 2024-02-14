package dp;

import java.io.*;

public class Boj_2748 {

    long[] dp;

    // 하향식 접근
    long fibo1(int n) {
        if (n == 1 || n == 2) return 1;
        if (dp[n] != 0) return dp[n];
        dp[n] = fibo1(n - 1) + fibo1(n - 2);
        return dp[n];
    }

    // 상향식 접근
    long fibo2(int n) {
        dp[1] = dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[n + 2];

        System.out.println(fibo1(n));
//        System.out.println(fibo2(n));
    }
}
