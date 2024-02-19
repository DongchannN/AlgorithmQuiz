package dp;

import java.io.*;
import java.util.*;

public class Boj_12865 {
    static class Stuff {
        int weight;
        int value;

        Stuff(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int[] dp = new int[k + 1];

        List<Stuff> stuffs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] nextLine = br.readLine().split(" ");
            int w = Integer.parseInt(nextLine[0]);
            int v = Integer.parseInt(nextLine[1]);
            stuffs.add(new Stuff(w, v));
        }

//        for (int i = 0; i <= k; i++) {
//            for (int j = 0; j < list.size(); j++) {
//                Stuff s = list.get(j);
//
//                if (i - s.weight >= 0)
//                    dp[i] = Math.max(dp[i], dp[i - s.weight] + s.value);
//            }
//        }
//        System.out.println(dp[k]);

        for (int i = 0; i < stuffs.size(); i++) {
            Stuff s = stuffs.get(i);
            for (int j = k; j >= s.weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - s.weight] + s.value);
            }
        }
        System.out.println(dp[k]);
    }
}
