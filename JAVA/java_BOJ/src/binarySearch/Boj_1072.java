package binarySearch;

import java.io.*;
import java.util.*;

public class Boj_1072 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        long x = Integer.parseInt(line[0]);
        long y = Integer.parseInt(line[1]);
        long z = (long) ((double) (y * 100) / x);

        long l = 0;
        long r = x;
        long cnt = -1;
        long newZ = z;
        while (l <= r) {
            long m = (l + r) / 2;
            long mid = (long) ((double) ((y + m) * 100) / (x + m));
            if (mid > z) {
                r = m - 1;
                newZ = mid;
                cnt = m;
            }
            else
                l = m + 1;
        }
        if (newZ == z)
            cnt = -1;
        System.out.println(cnt);
    }
}
