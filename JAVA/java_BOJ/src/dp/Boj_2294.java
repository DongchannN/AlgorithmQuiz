package dp;

import java.io.*;
import java.util.*;

public class Boj_2294 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        int[] coins = new int[n];
        int[] dp = new int[k + 1];
        Arrays.fill(dp, 100001);

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            if (coins[i] <= k) // 돈은 4800원 필요하지만 5000원짜리 동전이 있으면 ArrayIndex OutOfBound.
                dp[coins[i]] = 1;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (i + coins[j] <= k) // ArrayIndex Out of bounds 검사
                    dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1);
            }
        }
        if (dp[k] == 100001) System.out.println("-1");
        else System.out.println(dp[k]);
    }
}
