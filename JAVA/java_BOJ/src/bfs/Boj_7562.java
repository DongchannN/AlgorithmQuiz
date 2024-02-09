package bfs;

import java.io.*;
import java.util.*;

public class Boj_7562 {

    static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    boolean isOutOfBound(int row, int col, int size) {
        return (row < 0 || row >= size || col < 0 || col >= size);
    }

    int[] movePoint(int row, int col, int i) {
        int nr;
        int nc;
        if (i == 0) {
            nr = row - 2;
            nc = col + 1;
        } else if (i == 1) {
            nr = row - 1;
            nc = col + 2;
        } else if (i == 2) {
            nr = row + 1;
            nc = col + 2;
        } else if (i == 3) {
            nr = row + 2;
            nc = col + 1;
        } else if (i == 4) {
            nr = row + 2;
            nc = col - 1;
        } else if (i == 5) {
            nr = row + 1;
            nc = col - 2;
        } else if (i == 6) {
            nr = row - 1;
            nc = col - 2;
        } else {
            nr = row - 2;
            nc = col - 1;
        }
        return new int[]{nr, nc};
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            int size = Integer.parseInt(br.readLine());
            String[] line1 = br.readLine().split(" ");
            String[] line2 = br.readLine().split(" ");
            int sr = Integer.parseInt(line1[0]);
            int sc = Integer.parseInt(line1[1]);
            int er = Integer.parseInt(line2[0]);
            int ec = Integer.parseInt(line2[1]);

            if (sr == er && sc == ec) {
                System.out.println("0");
                continue;
            }
            int[][] map = new int[size][size];

            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(sr, sc));

            while (!queue.isEmpty()) {
                int exit = 0;
                Point now = queue.poll();
                for (int i = 0; i < 8; i++) {
                    int[] next = movePoint(now.row, now.col, i);
                    int nr = next[0];
                    int nc = next[1];

                    if (isOutOfBound(nr, nc, size)) continue;
                    if (map[nr][nc] != 0) continue;

                    map[nr][nc] = map[now.row][now.col] + 1;
                    if (nr == er && nc == ec) {
                        exit = 1;
                        break;
                    }
                    queue.offer(new Point(nr, nc));
                }
                if (exit == 1) break;
            }
            System.out.println(map[er][ec]);
        }
    }
}
