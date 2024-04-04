package graph.floyd_warshall;

import java.io.*;
import java.util.*;

public class Boj_11404 {
    public void solution() throws IOException {
        int INF = 100_000_001;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] dist = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            int weight = Integer.parseInt(line[2]);
            dist[start][end] = Math.min(weight, dist[start][end]);
        }

        for (int mid = 1; mid <= n; mid++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if (dist[s][mid] == INF
                            || dist[mid][e] == INF) continue;

                    if (dist[s][mid] + dist[mid][e] < dist[s][e])
                        dist[s][e] = dist[s][mid] + dist[mid][e];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int d = dist[i][j];
                if (d == INF) d = 0;
                sb.append(d).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
