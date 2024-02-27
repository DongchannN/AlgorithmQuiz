package dp_2;

import java.io.*;

public class Boj_11058 {
    static class Krill {
        long buffer;
        long count;

        Krill(long buffer, long count) {
            this.buffer = buffer;
            this.count = count;
        }
    }

    Krill compareKrill(Krill k1, Krill k2) {
        if (k1.count + k1.buffer <= k2.count + k2.buffer) return k2;
        else return k1;
    }

    Krill getMaxKrill(Krill k1, Krill k2) {
        if (k1.count <= k2.count) return k2;
        else return k1;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n < 7) {
            System.out.println(n);
            return ;
        }

        Krill[][] dp = new Krill[2][n + 1];
        dp[0][4] = new Krill(0, 4);
        dp[1][4] = new Krill(0, 4);
        dp[0][5] = new Krill(0, 4);
        dp[1][5] = new Krill(2, 4);
        dp[0][6] = new Krill(2, 6);
        dp[1][6] = new Krill(3, 6);

        for (int i = 7; i <= n; i++) {
            Krill k = compareKrill(dp[0][i - 1], dp[1][i - 1]);
            dp[0][i] = new Krill(k.buffer, k.count + k.buffer);
            Krill kk = getMaxKrill(dp[0][i - 3], dp[1][i - 3]);
            dp[1][i] = new Krill(kk.count, kk.count * 2);
        }

        System.out.println(getMaxKrill(dp[0][n], dp[1][n]).count);
    }
}
