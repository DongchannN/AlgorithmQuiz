package recursion;

import java.io.*;
import java.util.*;

public class Boj_2661 {

    static int n;
    int[] ans;
    boolean printed = false;

    /**
     * arr 은 좋은수열에 1개가 더해진 수열.
     * @param len
     * @return
     */
    boolean isGoodArr(int len) {
        boolean b = false;
        for (int i = 1; i <= len / 2; i++) {
            b = true;
            for (int j = 0; j < i; j++) {
                if (ans[len - 1 - j] != ans[len - 1 - j - i]) {
                    b = false;
                    break;
                }
            }
            if (b) break;
        }
        return (!b);
    }

    void recursion(int depth) {
        if (printed) return ;
        if (depth == n) {
            for (int i : ans)
                System.out.printf("%d", i);
            System.out.println();
            printed = true;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            ans[depth] = i;
            boolean isGood = isGoodArr(depth + 1);
            if (isGood)
                recursion(depth + 1);
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        ans = new int[n];

        recursion(0);
    }
}
