package recursion;

import java.util.*;
import java.io.*;

public class Boj_2758 {

    static long[][] dp;

    static long recursion(int idx, int last) {
        if (last <= 0) return 0;
        if (idx == 1) return last;

        if (dp[idx][last] == -1)
            dp[idx][last] = recursion(idx - 1, last / 2) + recursion(idx, last - 1);

        return dp[idx][last];
    }

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String[] input = br.readLine().split(" ");

            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            dp = new long[n + 1][m + 1];
            for (long[] arr : dp)
                Arrays.fill(arr, -1);

            long ans = recursion(n, m);
            System.out.println(ans);
        }
    }
}
