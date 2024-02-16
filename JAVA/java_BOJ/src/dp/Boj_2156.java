package dp;

import java.io.*;
import java.util.*;

public class Boj_2156 {

    int[][] dp;
    int[] arr;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[3][n + 1];
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(arr[0]);
            return ;
        }

        dp[0][1] = arr[0];
        dp[1][1] = arr[1];
        dp[2][1] = arr[0] + arr[1];

        for (int i = 2; i < n; i++) {
            dp[0][i] = Math.max(dp[2][i - 1], Math.max(dp[0][i - 1], dp[1][i - 1]));
            dp[1][i] = arr[i] + dp[0][i - 1];
            dp[2][i] = arr[i] + dp[1][i - 1];
        }

        System.out.println(Math.max(dp[2][n - 1], Math.max(dp[0][n - 1], dp[1][n - 1])));
    }
}
