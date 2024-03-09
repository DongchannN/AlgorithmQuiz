package bfs;

import java.io.*;
import java.util.*;

public class Boj_13565 {

    static int r, c;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    void bfs(int startRow, int startCol) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(startRow, startCol));
        map[startRow][startCol] = 2;

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dr[i];
                int nextCol = now.col + dc[i];
                if (nextRow < 0 || nextRow >= r || nextCol < 0 || nextCol >= c) continue;
                if (map[nextRow][nextCol] != 0) continue;
                map[nextRow][nextCol] = 2;
                q.offer(new Point(nextRow, nextCol));
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);

        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            line = br.readLine().split("");
            for (int j = 0; j < c; j++)
                map[i][j] = Integer.parseInt(line[j]);
        }

        for (int i = 0; i < c; i++) {
            bfs(0, i);
        }
        int flag = 0;
        for (int i = 0; i < c; i++) {
            if (map[r - 1][i] == 2) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) System.out.println("NO");
        else System.out.println("YES");
    }
}
