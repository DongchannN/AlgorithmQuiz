package dp_2;

import java.io.*;
import java.util.*;

public class Boj_1309 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[3][n + 1];

        dp[0][1] = 1;
        dp[1][1] = 1;
        dp[2][1] = 1;
        for (int i = 2; i <= n; i++) {
            int a = dp[0][i - 1];
            int b = dp[1][i - 1];
            int c = dp[2][i - 1];
            dp[0][i] = (a + b + c) % 9901;
            dp[1][i] = (a + c) % 9901;
            dp[2][i] = (a + b) % 9901;
        }

        System.out.println((dp[0][n] + dp[1][n] + dp[2][n]) % 9901);
    }
}
