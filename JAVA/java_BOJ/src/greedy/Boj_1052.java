package greedy;

import java.io.*;
import java.util.*;

public class Boj_1052 {
    static int[] powersOfTwo = new int[24];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        int num = 1;
        int idx = 23;
        for (int i = 0; i < 24; i++) {
            powersOfTwo[i] = num;
            num *= 2;
            if (num > n) {
                idx = i;
            }
        }

        for (int i = 0; i < k; i++) {
            while (idx >= 0 && n < powersOfTwo[idx]) {
                idx--;
            }
            if (idx < 0) {
                break;
            }
            n -= powersOfTwo[idx];
        }
        if (idx < 0 || n == 0) {
            System.out.println(n);
        } else {
            System.out.println(powersOfTwo[idx] - n);
        }
    }
}
