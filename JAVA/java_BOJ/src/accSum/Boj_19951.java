package accSum;

import java.util.*;
import java.io.*;

public class Boj_19951 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);

        int[] groundHeight = new int[n];
        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            groundHeight[i] = Integer.parseInt(s2[i]);

        int[] heightChange = new int[n + 1];
        for (int i = 0; i < m; i++) {
            String[] s3 = br.readLine().split(" ");
            int a = Integer.parseInt(s3[0]);
            int b = Integer.parseInt(s3[1]);
            int k = Integer.parseInt(s3[2]);

            heightChange[a - 1] += k;
            heightChange[b] -= k;
        }
        for (int i = 1; i < n + 1; i++)
            heightChange[i] += heightChange[i - 1];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(groundHeight[i] + heightChange[i] + " ");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
