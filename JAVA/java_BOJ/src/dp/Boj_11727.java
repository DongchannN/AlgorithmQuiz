package dp;

import java.io.*;
import java.util.*;

public class Boj_11727 {
    long[] dp;

    long setDp(int depth) {
        if (depth == 1) return 1;
        if (depth == 2) return 3;
        if (dp[depth] != 0) return dp[depth];
        dp[depth] = (setDp(depth - 1) + setDp(depth - 2) * 2) % 10007;
        return dp[depth];
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new long[n + 2];
        System.out.println(setDp(n) % 10007);
    }
}
