package bfs;

import java.io.*;
import java.util.*;

public class Boj_1194 {

    static int r, c;
    static char[][] map;
    static int[][][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static final int DOOR = 1;
    static final int KEY = 2;
    static final int EXIT = 3;
    static final int WALL = 4;
    static final int NONE = 5;

    static class Point {
        int row;
        int col;
        int keys;

        Point(int row, int col, int keys) {
            this.row = row;
            this.col = col;
            this.keys = keys;
        }
    }

    int getType(char c) {
        if (c == '#') return WALL;
        else if (c == '.' || c == '0') return NONE;
        else if ('a' <= c && c <= 'f') return KEY;
        else if ('A' <= c && c <= 'F') return DOOR;
        else if (c == '1') return EXIT;
        else return -1;
    }

    void bfs(int startRow, int startCol) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(startRow, startCol, 0));
        visited[startRow][startCol][0] = 1;

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextR = now.row + dr[i];
                int nextC = now.col + dc[i];
                if (nextR < 0 || nextR >= r
                        || nextC < 0 || nextC >= c) continue;

                char next = map[nextR][nextC];
                switch (getType(next)) {
                    case WALL :
                        continue;
                    case NONE :
                        if (visited[nextR][nextC][now.keys] == 0) {
                            visited[nextR][nextC][now.keys] = visited[now.row][now.col][now.keys] + 1;
                            q.offer(new Point(nextR, nextC, now.keys));
                        }
                        break ;
                    case KEY :
                        int addedKeys = now.keys | (1 << (next - 'a'));
                        if (visited[nextR][nextC][addedKeys] == 0) {
                            visited[nextR][nextC][addedKeys] = visited[now.row][now.col][now.keys] + 1;
                            q.offer(new Point(nextR, nextC, addedKeys));
                        }
                        break ;
                    case DOOR :
                        int keyMatch = now.keys & (1 << (next - 'A'));
                        if (keyMatch != 0 && visited[nextR][nextC][now.keys] == 0) {
                            visited[nextR][nextC][now.keys] = visited[now.row][now.col][now.keys] + 1;
                            q.offer(new Point(nextR, nextC, now.keys));
                        }
                        break ;
                    case EXIT :
                        System.out.println(visited[now.row][now.col][now.keys]);
                        return ;
                }
            }
        }
        System.out.println("-1");
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);

        int startRow = -1;
        int startCol = -1;
        visited = new int[r][c][64];
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '0') {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        bfs(startRow, startCol);
    }
}
