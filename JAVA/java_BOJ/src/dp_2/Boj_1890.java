package dp_2;

import java.io.*;
import java.util.*;

public class Boj_1890 {

    static int n;
    static int[][] map;

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n][n];
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int amount = map[i][j];
                if (amount == 0) continue;
                long pathCnt = dp[i][j];
                if (pathCnt == 0) continue;

                if (j + amount < n) dp[i][j + amount] += pathCnt;
                if (i + amount < n) dp[i + amount][j] += pathCnt;
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }
}
