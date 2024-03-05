package dfs;

import java.io.*;
import java.util.*;

public class Boj_1189 {
    static int r, c, dist;
    static int cnt = 0;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static int[][] visited;

    public void dfs(int row, int col, int d) {
        if (d > dist) return ;
        if (row == 0 && col == c - 1) {
            if (d == dist) cnt++;
            return ;
        }

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dr[i];
            int nextCol = col + dc[i];
            if (nextRow < 0 || nextRow >= r || nextCol < 0 || nextCol >= c) continue;
            if (visited[nextRow][nextCol] != 0) continue;
            visited[nextRow][nextCol] = 1;
            dfs(nextRow, nextCol, d + 1);
            visited[nextRow][nextCol] = 0;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);
        dist = Integer.parseInt(line[2]);

        map = new int[r][c];
        visited = new int[r][c];
        for (int i = 0; i < r; i++) {
            line = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                if (line[j].equals("T")) visited[i][j] = 1;
            }
        }

        visited[r - 1][0] = 1;
        dfs(r - 1, 0, 1);
        System.out.println(cnt);
    }
}
