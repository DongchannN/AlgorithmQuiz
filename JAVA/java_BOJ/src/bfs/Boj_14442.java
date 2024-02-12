package bfs;

import java.io.*;
import java.util.*;

public class Boj_14442 {
    int r, c, k;
    int[][] map;
    int[][][] visited;
    boolean canExit = false;

    static class Point {
        int row;
        int col;
        int breakCnt;

        Point(int row, int col, int breakCnt) {
            this.row = row;
            this.col = col;
            this.breakCnt = breakCnt;
        }
    }

    void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 0));
        visited[0][0][0] = 1;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            Point now = q.poll();
            if (now.row == r - 1 && now.col == c - 1) {
                canExit = true;
                System.out.println(visited[now.row][now.col][now.breakCnt]);
                return ;
            }
            for (int i = 0; i < 4; i++) {
                int nextR = now.row + dr[i];
                int nextC = now.col + dc[i];
                if (nextR < 0 || nextR >= r
                        || nextC < 0 || nextC >= c) continue;
                if (visited[nextR][nextC][now.breakCnt] != 0) continue;

                if (map[nextR][nextC] == 0) {
                    q.offer(new Point(nextR, nextC, now.breakCnt));
                    visited[nextR][nextC][now.breakCnt] = visited[now.row][now.col][now.breakCnt] + 1;
                } else if (map[nextR][nextC] == 1 && now.breakCnt < k && visited[nextR][nextC][now.breakCnt + 1] == 0) {
                    q.offer(new Point(nextR, nextC, now.breakCnt + 1));
                    visited[nextR][nextC][now.breakCnt + 1] = visited[now.row][now.col][now.breakCnt] + 1;
                }
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);
        k = Integer.parseInt(line[2]);

        map = new int[r][c];
        visited = new int[r][c][k + 1];
        for (int i = 0; i < r; i++) {
            String[] nextLine = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(nextLine[j]);
            }
        }

        bfs();
        if (!canExit) System.out.println("-1");
    }
}
