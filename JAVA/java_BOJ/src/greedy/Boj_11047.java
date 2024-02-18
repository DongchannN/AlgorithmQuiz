package greedy;

import java.io.*;
import java.util.*;

public class Boj_11047 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        int[] moneys = new int[n];
        for (int i = n - 1; i >= 0; i--)
            moneys[i] = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int money : moneys) {
            int m = k / money;
            ans += m;
            k -= (m * money);
        }
        System.out.println(ans);
    }
}
