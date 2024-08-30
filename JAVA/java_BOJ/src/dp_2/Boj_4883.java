package dp_2;

import java.io.*;

public class Boj_4883 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int tc = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            int[][] arr = new int[n][3];
            int[][] dp = new int[n][3];
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                arr[i][0] = Integer.parseInt(s[0]);
                arr[i][1] = Integer.parseInt(s[1]);
                arr[i][2] = Integer.parseInt(s[2]);
            }
            int startVal = arr[0][1];
            dp[0][0] = startVal;
            dp[0][1] = startVal;
            dp[0][2] = startVal + arr[0][2];
            dp[1][0] = startVal + arr[1][0];
            dp[1][1] = Math.min(Math.min(startVal, dp[0][2]), dp[1][0]) + arr[1][1];
            dp[1][2] = Math.min(Math.min(startVal, dp[0][2]), dp[1][1]) + arr[1][2];
            for (int i = 2; i < n; i++) {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][0];
                dp[i][1] = Math.min(
                            Math.min(dp[i - 1][0], dp[i - 1][1]),
                            Math.min(dp[i - 1][2], dp[i][0])) + arr[i][1];
                dp[i][2] = Math.min(Math.min(dp[i - 1][1], dp[i - 1][2]), dp[i][1]) + arr[i][2];
            }
            int ans = Math.min(
                        Math.min(dp[n - 2][0], dp[n - 2][1]),
                        Math.min(dp[n - 2][2], dp[n - 1][0])) + arr[n - 1][1];
            sb.append(tc++).append(". ").append(ans).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
