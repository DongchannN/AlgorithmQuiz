package bfs;

import java.io.*;
import java.util.*;

public class Boj_2178 {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    int n, m;
    int[][] map;
    int[][] distance;
    int cnt = 0;

    static class Position {
        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    void bfs(int startRow, int startCol) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(startRow, startCol));
        distance[startRow][startCol] = 1;

        while (!queue.isEmpty()) {
            Position polled = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = polled.row + dr[i];
                int nextCol = polled.col + dc[i];
                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) continue;
                if (distance[nextRow][nextCol] == 0 && map[nextRow][nextCol] == 1) {
                    distance[nextRow][nextCol] = distance[polled.row][polled.col] + 1;
                    queue.add(new Position(nextRow, nextCol));
                }
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        distance = new int[n][m];
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] nextLine = br.readLine().split("");
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(nextLine[j]);
        }
        bfs(0, 0);

        System.out.println(distance[n - 1][m - 1]);
    }
}
