package dp_2;

import java.io.*;

public class Boj_21317 {
    static int n, k;
    static int[][] energy;
    static int[][] dp;
    static boolean[][] visited;

    static int getMinOfPure(int n) {
        if (!visited[n][1])
            return dp[n][0];
        return Math.min(dp[n][0], dp[n][1]);
    }

    static int getMinOfUsedSuperJump(int n) {
        if (!visited[n][3])
            return dp[n][2];
        if (!visited[n][4])
            return Math.min(dp[n][2], dp[n][3]);
        return Math.min(Math.min(dp[n][2], dp[n][3]), dp[n][4]);
    }

    static int getMinOfFinal(int n) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            if (!visited[n][i])
                continue;
            min = Math.min(min, dp[n][i]);
        }
        return min;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        energy = new int[n][2];
        dp = new int[n + 1][5];
        visited = new boolean[n + 1][5];
        energy[0][0] = 0;
        energy[0][1] = 0;
        String[] line;
        for (int i = 0; i < n - 1; i++) {
            line = br.readLine().split(" ");
            energy[i][0] = Integer.parseInt(line[0]);
            energy[i][1] = Integer.parseInt(line[1]);
        }
        k = Integer.parseInt(br.readLine());
        visited[0][0] = true;
        visited[0][1] = true;
        for (int i = 1; i < n; i++) {
            dp[i][0] = getMinOfPure(i - 1) + energy[i - 1][0];
            visited[i][0] = true;
            if (i > 1) {
                dp[i][1] = getMinOfPure(i - 2) + energy[i - 2][1];
                visited[i][1] = true;
            }
            if (i > 2) {
                dp[i][2] = getMinOfPure(i - 3) + k;
                visited[i][2] = true;
            }
            if (i > 3) {
                dp[i][3] = getMinOfUsedSuperJump(i - 1) + energy[i - 1][0];
                visited[i][3] = true;
            }
            if (i > 4) {
                dp[i][4] = getMinOfUsedSuperJump(i - 2) + energy[i - 2][1];
                visited[i][4] = true;
            }
        }
        System.out.println(getMinOfFinal(n - 1));
    }
}
