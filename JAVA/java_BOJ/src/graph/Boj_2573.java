package graph;

import java.io.*;
import java.util.*;

public class Boj_2573 {

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    int r;
    int c;
    int[][] map;

    static class Position {
        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    boolean canGo(int row, int col) {
        if (row >= r || row < 0 || col >= c || col < 0)
            return false;
        if (map[row][col] <= 0)
            return false;
        return true;
    }

    void bfs(boolean[][] visited, int startRow, int startCol) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(startRow, startCol));
        visited[startRow][startCol] = true;
        while (!queue.isEmpty()){
            Position p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = p.row + dr[i];
                int nextCol = p.col + dc[i];
                if (canGo(nextRow, nextCol)
                        && !visited[nextRow][nextCol]){
                    queue.offer(new Position(nextRow, nextCol));
                    visited[nextRow][nextCol] = true;
                }
            }
        }
    }

    int checkOnePiece() {
        int startRow = -1;
        int startCol = -1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != 0) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        if (startRow == -1) return -1; // 얼음이 모두 녹은 경우.

        // bfs로 탐색.
        boolean[][] visited = new boolean[r][c];
        bfs(visited, startRow, startCol);

        // 만약 map의 요소가 0이 아니며 false인 부분이 있다면 덩어리가 1개가 아님 -> return 1;
        // 덩어리가 한개면 return 0
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != 0 && !visited[i][j]) return 1;
            }
        }
        return 0;
    }

    void melt() {
        int[][] meltAmount = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        int row = i + dr[k];
                        int col = j + dc[k];
                        if (row >= r || row < 0 || col >= c || col < 0) continue;
                        if (map[row][col] == 0) meltAmount[i][j]--;
                    }
                }
            }
        }
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                map[i][j] = Math.max(0, map[i][j] + meltAmount[i][j]);
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);
        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            String[] nextLine = br.readLine().split(" ");
            for (int j = 0; j < c; j++)
                map[i][j] = Integer.parseInt(nextLine[j]);
        }

        int year = 0;
        int ret = 0;
        while (true) {
            ret = checkOnePiece();
            if (ret == -1 || ret == 1) break;
            melt();
            year++;
        }
        if (ret == -1) year = 0;
        System.out.println(year);
    }
}
