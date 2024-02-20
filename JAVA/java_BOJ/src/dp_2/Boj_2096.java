package dp_2;

import java.io.*;
import java.util.*;

public class Boj_2096 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] maxDp = new int[n + 1][3];
        int[][] minDp = new int[n + 1][3];
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 3; j++)
                arr[i][j] = Integer.parseInt(line[j]);
        }

        for (int i = 0; i < 3; i++) {
            maxDp[1][i] = arr[0][i];
            minDp[1][i] = arr[0][i];
        }

        for (int i = 2; i <= n; i++) {
            int pMax1 = maxDp[i - 1][0];
            int pMax2 = maxDp[i - 1][1];
            int pMax3 = maxDp[i - 1][2];
            int pMin1 = minDp[i - 1][0];
            int pMin2 = minDp[i - 1][1];
            int pMin3 = minDp[i - 1][2];

            maxDp[i][0] = arr[i - 1][0] + Math.max(pMax1, pMax2);
            maxDp[i][1] = arr[i - 1][1] + Math.max(Math.max(pMax1, pMax2), pMax3);
            maxDp[i][2] = arr[i - 1][2] + Math.max(pMax2, pMax3);

            minDp[i][0] = arr[i - 1][0] + Math.min(pMin1, pMin2);
            minDp[i][1] = arr[i - 1][1] + Math.min(Math.min(pMin1, pMin2), pMin3);
            minDp[i][2] = arr[i - 1][2] + Math.min(pMin2, pMin3);
        }

        int max = Math.max(Math.max(maxDp[n][0], maxDp[n][1]), maxDp[n][2]);
        int min = Math.min(Math.min(minDp[n][0], minDp[n][1]), minDp[n][2]);
        System.out.printf("%d %d\n", max, min);
    }
}
