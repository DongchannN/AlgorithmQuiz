package accSum;

import java.io.*;
import java.util.*;

public class Boj_16507 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int r = Integer.parseInt(line[0]);
        int c = Integer.parseInt(line[1]);
        int q = Integer.parseInt(line[2]);

        int[][] acc = new int[r + 1][c + 1];
        for (int i = 1; i <= r; i++) {
            String[] nextLine1 = br.readLine().split(" ");
            for (int j = 1; j <= c; j++) {
                acc[i][j] = acc[i][j - 1] + acc[i - 1][j] - acc[i - 1][j - 1] + Integer.parseInt(nextLine1[j - 1]);
            }
        }

        for (int i = 0; i < q; i++) {
            String[] nextLine2 = br.readLine().split(" ");
            int r1 = Integer.parseInt(nextLine2[0]);
            int c1 = Integer.parseInt(nextLine2[1]);
            int r2 = Integer.parseInt(nextLine2[2]);
            int c2 = Integer.parseInt(nextLine2[3]);

            int amount = (r2 - r1 + 1) * (c2 - c1 + 1);
            int sum = acc[r2][c2] - acc[r2][c1 - 1] - acc[r1 - 1][c2] + acc[r1 - 1][c1 - 1];

            System.out.println(sum / amount);
        }

    }
}
