package bfs;

import java.io.*;
import java.util.*;

public class Boj_5427 {

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    int[][] fireTime;
    int[][] movingTime;
    int row, col;
    boolean canExit = false;

    static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    boolean isOutOfBound(int r, int c) {
        return (r < 0 || r >= row || c < 0 || c >= col);
    }

    void fireBfs(Queue<Point> fireQ, Queue<Point> moverQ) {
        while (!fireQ.isEmpty()) {
            Point fire = fireQ.poll();
            for (int i = 0; i < 4; i++) {
                int nextR = fire.row + dr[i];
                int nextC = fire.col + dc[i];
                if (isOutOfBound(nextR, nextC)) continue;

                if (fireTime[nextR][nextC] == 0) {
                    fireQ.offer(new Point(nextR, nextC));
                    fireTime[nextR][nextC] = fireTime[fire.row][fire.col] + 1;
                }
            }
        }

        canExit = false;
        while (!moverQ.isEmpty()) {
            Point mover = moverQ.poll();
            if (mover.row == 0 || mover.row == row - 1
                    || mover.col == 0 || mover.col == col - 1) {
                System.out.println(movingTime[mover.row][mover.col]);
                canExit = true;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextR = mover.row + dr[i];
                int nextC = mover.col + dc[i];
                if (isOutOfBound(nextR, nextC)) continue;
                if (movingTime[nextR][nextC] != 0) continue;

                if(fireTime[nextR][nextC] == 0 || fireTime[nextR][nextC] > movingTime[mover.row][mover.col] + 1){
                    moverQ.offer(new Point(nextR, nextC));
                    movingTime[nextR][nextC] = movingTime[mover.row][mover.col] + 1;
                }
            }
        }
        if (!canExit) System.out.println("IMPOSSIBLE");
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String[] line = br.readLine().split(" ");
            col = Integer.parseInt(line[0]);
            row = Integer.parseInt(line[1]);
            fireTime = new int[row][col]; // 시간에 따라 불이 언제 났는지 기록한 배열.
            movingTime = new int[row][col];
            Queue<Point> fireQ = new LinkedList<>(); // bfs 시 불에 관한 정보 담는 큐
            Queue<Point> moverQ = new LinkedList<>();

            // 빈공간(.) : 0, 벽(#) : -1, 상근이 위치(@) : 2, 불(*) : 1
            for (int i = 0; i < row; i++) {
                String[] nextLine = br.readLine().split("");
                for (int j = 0; j < col; j++) {
                    if (nextLine[j].equals("#")) {
                        fireTime[i][j] = -1;
                        movingTime[i][j] = -1;
                    } else if (nextLine[j].equals("@")) {
                        moverQ.offer(new Point(i, j));
                        movingTime[i][j] = 1;
                    } else if (nextLine[j].equals("*")) {
                        fireQ.offer(new Point(i, j));
                        fireTime[i][j] = 1;
                    }
                }
            }

            fireBfs(fireQ, moverQ);
        }
    }
}
