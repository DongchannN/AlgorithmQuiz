package bfs;

import java.io.*;
import java.util.*;

public class Boj_7576 {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    int row, col;
    int[][] map;
    int[][] visited;

    static class Point {
        int idx;
        int row;
        int col;

        Point(int row, int col) {
            idx = (row * col) + col;
            this.row = row;
            this.col = col;
        }
    }

    void bfs() {
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (map[i][j] == 1) {
                    q.offer(new Point(i, j));
                    visited[i][j] = 1;
                }

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dr[i];
                int nextCol = now.col + dc[i];
                if (nextRow < 0 || nextRow >= row
                        || nextCol < 0 || nextCol >= col)
                    continue;
                if (visited[nextRow][nextCol] != 0 || map[nextRow][nextCol] == -1) continue;

                q.offer(new Point(nextRow, nextCol));
                visited[nextRow][nextCol] = visited[now.row][now.col] + 1;
                map[nextRow][nextCol] = 1;
            }
        }
    }


    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        col = Integer.parseInt(line[0]);
        row = Integer.parseInt(line[1]);
        map = new int[row][col];
        visited = new int[row][col];

        for (int i = 0; i < row; i++) {
            String[] nextLine = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(nextLine[j]);
            }
        }

        bfs();
        int ans = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0) {
                    System.out.println("-1");
                    System.exit(0);
                }
                ans = Math.max(ans, visited[i][j]);
            }
        }
        System.out.println(ans - 1);
    }
}
