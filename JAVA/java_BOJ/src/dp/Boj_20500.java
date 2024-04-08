package dp;

import java.io.*;
import java.util.*;

public class Boj_20500 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 2];
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + (2 * dp[i - 2])) % 1000000007;
        }
        System.out.println(dp[n]);
    }
}
