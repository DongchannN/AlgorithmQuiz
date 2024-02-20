package dp_2;

import java.io.*;
import java.util.*;

public class Boj_10844 {

    int[][] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 2][10];
        for (int i = 0; i < 10; i++)
            dp[1][i] = 1;
        dp[2][0] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0)
                    dp[i][j] = dp[i - 1][j + 1];
                else if (j == 9)
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                dp[i][j] %= 1000000000;
             }
        }
        int ans = 0;
        for (int i = 1; i < 10; i++) {
            ans += dp[n][i];
            ans %= 1000000000;
        }
        System.out.println(ans);
    }
}
