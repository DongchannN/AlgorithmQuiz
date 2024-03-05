package bfs;

import java.io.*;
import java.util.*;

public class Boj_2583 {

    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    int[][] map;
    int n, m;

    static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    void fillSquare(int r1, int c1, int r2, int c2) {
        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                map[i][j] = 1;
            }
        }
    }

    int bfs(int row, int col) {
        Queue<Point> q = new LinkedList<>();
        int cnt = 1;
        map[row][col] = 1;
        q.offer(new Point(row, col));

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dy[i];
                int nextCol = now.col + dx[i];
                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) continue;
                if (map[nextRow][nextCol] != 0) continue;

                q.offer(new Point(nextRow, nextCol));
                map[nextRow][nextCol] = 1;
                cnt++;
            }
        }
        return cnt;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        m = Integer.parseInt(line[0]);
        n = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);

        List<Integer> list = new ArrayList<>();
        map = new int[m][n];
        for (int i = 0; i < k; i++) {
            String[] nextLine = br.readLine().split(" ");
            int c1 = Integer.parseInt(nextLine[0]);
            int r1 = Integer.parseInt(nextLine[1]);
            int c2 = Integer.parseInt(nextLine[2]);
            int r2 = Integer.parseInt(nextLine[3]);
            fillSquare(r1, c1, r2, c2);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    int ret = bfs(i, j);
                    list.add(ret);
                }
            }
        }
        list.sort((a, b) -> a - b);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d ", list.get(i));
        }
    }
}
