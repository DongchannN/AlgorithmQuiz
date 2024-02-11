package bfs;

import java.io.*;
import java.util.*;

public class Boj_2206 {

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    int r, c;
    int[][] map;
    int[][][] visited;

    static class Point {
        int row;
        int col;
        int isBroken;

        Point(int row, int col, int isBroken) {
            this.row = row;
            this.col = col;
            this.isBroken = isBroken;
        }
    }

    void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 0));
        visited[0][0][0] = 1;

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextR = now.row + dr[i];
                int nextC = now.col + dc[i];
                if (nextR < 0 || nextR >= r
                        || nextC < 0 || nextC >= c) continue;
                if (visited[nextR][nextC][now.isBroken] != 0) continue;

                if (map[nextR][nextC] == 0) {
                    visited[nextR][nextC][now.isBroken] = visited[now.row][now.col][now.isBroken] + 1;
                    q.offer(new Point(nextR, nextC, now.isBroken));
                } else if (map[nextR][nextC] == 1 && now.isBroken == 0) {
                    visited[nextR][nextC][1] = visited[now.row][now.col][now.isBroken] + 1;
                    q.offer(new Point(nextR, nextC, 1));
                }
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);

        map = new int[r][c];
        visited = new int[r][c][2];
        for (int i = 0; i < r; i++) {
            String[] nextLine = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(nextLine[j]);
            }
        }
        bfs();

        int a = visited[r - 1][c - 1][0];
        int b = visited[r - 1][c - 1][1];

        if (a == 0 && b == 0) System.out.println("-1");
        else if (a == 0) System.out.println(b);
        else if (b == 0) System.out.println(a);
        else System.out.println(Math.min(a, b));
    }
}
