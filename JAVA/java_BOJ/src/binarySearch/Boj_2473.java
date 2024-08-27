package binarySearch;

import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Boj_2473 {
    static int[] bottles;
    static int n;

    static int findBottle(int l, int r, long sum) {
        long minAbs = Long.MAX_VALUE;
        int ret = bottles[(l + r) / 2];
        while (l <= r) {
            int mid = (l + r) / 2;
            long sum3 = sum + bottles[mid];
            if (sum3 == 0) {
                return bottles[mid];
            }
            if (Math.abs(sum3) < Math.abs(minAbs)) {
                minAbs = Math.abs(sum3);
                ret = bottles[mid];
            }
            if (sum3 < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ret;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        int[] ans = new int[3];

        bottles = new int[n];
        for (int i = 0; i < n; i++)
            bottles[i] = Integer.parseInt(strArr[i]);
        Arrays.sort(bottles);

        long minAbs = Long.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 2; j < n; j++) {
                long sum2 = bottles[i] + bottles[j];
                int ret = findBottle(i + 1, j - 1, sum2);
                long sum3 = sum2 + (long) ret;
                if (Math.abs(minAbs) > Math.abs(sum3)) {
                    ans[0] = bottles[i];
                    ans[1] = ret;
                    ans[2] = bottles[j];
                    minAbs = Math.abs(sum3);
                }
                if (sum3 == 0) {
                    Arrays.sort(ans);
                    System.out.printf("%d %d %d\n", ans[0], ans[1], ans[2]);
                    exit(0);
                }
            }
        }
        Arrays.sort(ans);
        System.out.printf("%d %d %d\n", ans[0], ans[1], ans[2]);
    }
}
