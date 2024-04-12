package graph;

import java.io.*;
import java.util.*;

public class Boj_10216 {
    static List<Integer>[] map;
    static boolean[] visited;

    static class Point {
        int x;
        int y;
        int r;

        Point(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    static boolean canCommunicate(Point p1, Point p2) {
        double dist = Math.sqrt(Math.pow(p1.x-p2.x, 2) + Math.pow(p1.y-p2.y, 2));
        return dist <= (p1.r + p2.r);
    }

    static void recursion(int idx) {
        List<Integer> canGo = map[idx];
        visited[idx] = true;

        for (int next : canGo) {
            if (visited[next]) continue;
            recursion(next);
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());

            Point[] points = new Point[n];
            visited = new boolean[n];
            map = new ArrayList[n];
            for (int i = 0; i < n; i++)
                map[i] = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                int x = Integer.parseInt(line[0]);
                int y = Integer.parseInt(line[1]);
                int r = Integer.parseInt(line[2]);
                points[i] = new Point(x, y, r);
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (i == j) continue;
                    if (canCommunicate(points[i], points[j])) {
                        map[i].add(j);
                        map[j].add(i);
                    }
                }
            }

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    recursion(i);
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
