package dp_2;

import java.io.*;
import java.util.*;

public class Boj_2157 {
    static int n, m, k;
    static List<Plane>[] map;
    static int[][] dp;

    static class Plane {
        int dest;
        int point;

        Plane (int dest, int point) {
            this.dest = dest;
            this.point = point;
        }
    }

    static boolean removeWorsePlane(int src, int dest, int point) {
        boolean hasSamePlane = false;
        for (Plane plane : map[src]) {
            if (plane.dest == dest) {
                hasSamePlane = true;
                if (plane.point <= point) {
                    map[src].remove(plane);
                    return true;
                }
            }
        }
        return !hasSamePlane;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        k = Integer.parseInt(line[2]);
        map = new ArrayList[n];
        dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < k; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]) - 1;
            int b = Integer.parseInt(line[1]) - 1;
            int c = Integer.parseInt(line[2]);
            if (a > b)
                continue;
            if (!removeWorsePlane(a, b, c))
                continue;
            map[a].add(new Plane(b, c));
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[n - 1][1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            List<Plane> planes = map[i];
            for (Plane plane : planes) {
                int dest = plane.dest;
                for (int cnt = 0; cnt < n + 1; cnt++) {
                    if (dp[dest][cnt] == -1) continue;
                    dp[i][cnt + 1] = Math.max(dp[i][cnt + 1], dp[dest][cnt] + plane.point);
                }
            }
        }
        int greatest = 0;
        for (int i = m; i >= 0; i--) {
            greatest = Math.max(greatest, dp[0][i]);
        }
        System.out.println(greatest);
    }
}
