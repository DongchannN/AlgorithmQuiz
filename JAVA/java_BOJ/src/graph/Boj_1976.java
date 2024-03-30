package graph;

import java.io.*;
import java.util.*;

public class Boj_1976 {
    static int n, m;
    static int[][] map;
    static int[] parents;

    static int find(int n) {
        if (parents[n] == n) return n;
        return find(parents[n]);
    }

    static int adv_find(int n) {
        if (parents[n] != n) parents[n] = find(parents[n]);
        return parents[n];
    }

    static void union(int n1, int n2) {
        n1 = adv_find(n1);
        n2 = adv_find(n2);
        if (n1 == n2) return ;

        if (n1 < n2) parents[n2] = n1;
        else parents[n1] = n2;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++)
            parents[i] = i;

        map = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                if (map[i][j] == 1) {
                    union(i + 1, j + 1);
                }
            }
        }

        int[] togo = new int[m];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < m; i++)
            togo[i] = Integer.parseInt(line[i]);

        boolean canGo = true;
        for (int i = 0; i < m - 1; i++) {
            int n1 = adv_find(togo[i]);
            int n2 = adv_find(togo[i + 1]);
            if (n1 == n2) continue;
            canGo = false;
            break;
        }
        if (canGo) System.out.println("YES");
        else System.out.println("NO");
    }
}
