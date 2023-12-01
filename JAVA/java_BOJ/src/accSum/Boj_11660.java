package accSum;

import java.util.*;
import java.io.*;

public class Boj_11660 {
    public void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int c = Integer.parseInt(s[1]);

        int[][] arr = new int[n + 1][n + 1];
        int[][] acc = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            String[] s2 = bf.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i + 1][j + 1] = Integer.parseInt(s2[j]);
                acc[i + 1][j + 1]
                        = arr[i + 1][j + 1] + acc[i][j + 1]
                        + acc[i + 1][j] - acc[i][j];
            }
        }

        for (int i = 0; i < c; i++) {
            String[] s3 = bf.readLine().split(" ");
            int x1 = Integer.parseInt(s3[0]);
            int y1 = Integer.parseInt(s3[1]);
            int x2 = Integer.parseInt(s3[2]);
            int y2 = Integer.parseInt(s3[3]);

            int ans = acc[x2][y2] - acc[x1 - 1][y2] - acc[x2][y1 - 1] + acc[x1 - 1][y1 - 1];
            System.out.println(ans);
        }
    }
}
