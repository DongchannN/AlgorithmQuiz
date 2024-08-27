package binarySearch;

import java.io.*;
import java.util.*;

public class Boj_16564 {

    static int[] levels;
    static int n, k;

    static long getTotalSum(long targetLevel) {
        long sum = 0;
        long sub;
        for (int lev : levels) {
            sub = targetLevel - lev;
            if (sub > 0)
                sum += sub;
        }
        return sum;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        k = Integer.parseInt(line[1]);
        levels = new int[n];
        int minLev = Integer.MAX_VALUE;
        int maxLev = 0;
        for (int i = 0; i < n; i++) {
            levels[i] = Integer.parseInt(br.readLine());
            minLev = Math.min(minLev, levels[i]);
            maxLev = Math.max(maxLev, levels[i]);
        }
        long l = minLev;
        long r = maxLev + k;
        long targetLevel = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            long sum = getTotalSum(mid);
            if (k < sum) {
                r = mid - 1;
            }
            else {
                targetLevel = Math.max(targetLevel, mid);
                l = mid + 1;
            }
        }
        System.out.println(targetLevel);
    }
}
