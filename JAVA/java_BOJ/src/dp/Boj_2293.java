package dp;

import java.io.*;
import java.util.*;

public class Boj_2293 {

    int n, k;
    int[][] dp;
    int[] coins;
    int getDp(int money, int idx) {
        int ret = 0;
        int c =  coins[idx];
        for (int i = idx; i < n; i++)
            if (0 <= money - c && money - c <= k)
                ret += dp[i][money - c];
        return ret;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        k = Integer.parseInt(line[1]);

        dp = new int[n][k + 1];
        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            if (coins[i] <= k)
                dp[i][coins[i]] = 1;
        }

        for (int now = 1; now <= k; now++) {
            for (int i = 0; i < n; i++) {
                int ret = getDp(now, i);

                dp[i][now] = Math.max(ret, dp[i][now]);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++)
            ans += dp[i][k];
        System.out.println(ans);
    }
}
