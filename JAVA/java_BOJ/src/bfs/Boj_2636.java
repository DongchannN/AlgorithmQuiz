package bfs;

import java.io.*;
import java.util.*;

public class Boj_2636 {
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

    static boolean isIndexOutOfBound(int row, int col) {
        return (row < 0 || row >= r
                || col < 0 || col >= c);
    }

    static void checkAirByBFS() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        map[0][0] = 2;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nRow = now.row + dr[i];
                int nCol = now.col + dc[i];

                if (isIndexOutOfBound(nRow, nCol)) continue;
                if (map[nRow][nCol] == 1 || map[nRow][nCol] == 2) continue;

                map[nRow][nCol] = 2;
                q.offer(new Point(nRow, nCol));
            }
        }
    }

    static int melt() {
        int cnt = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != 1) continue;

                for (int k = 0; k < 4; k++) {
                    if (isIndexOutOfBound(i + dr[k], j + dc[k])) continue;
                    if (map[i + dr[k]][j + dc[k]] == 2) {
                        map[i][j] = 3;
                        cnt++;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (map[i][j] == 2 || map[i][j] == 3) map[i][j] = 0;
        return cnt;
    }

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);

        int cheese = 0;
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                if (map[i][j] == 1) cheese++;
            }
        }

        checkAirByBFS();
        int time = 1;
        while (true) {
            int ret = melt();
            cheese -= ret;

            if (cheese <= 0) {
                System.out.println(time);
                System.out.println(ret);
                break;
            }

            checkAirByBFS();
            time++;
        }
    }
}
