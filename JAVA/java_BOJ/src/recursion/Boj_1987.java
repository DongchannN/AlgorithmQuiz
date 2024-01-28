package recursion;

import java.util.*;
import java.io.*;

public class Boj_1987 {

    static int[] moveY = {-1, 1, 0, 0};
    static int[] moveX = {0, 0, -1, 1};

    static int r;
    static int c;
    static char[][] map;
    static int[][] routes; // routes[row][col] -> 도달 하였을 때 알파벳의 경로 비트마스킹
    static boolean[] visited = new boolean[26];
    static int ans = 1;

    /**
     * if parameter (nowRow, nowCol) is out of bound return true
     */
    boolean isOutOfBound(int nowRow, int nowCol) {
        return (nowRow < 0 || nowRow >= r || nowCol < 0 || nowCol >= c);
    }

    /**
     * base case : 상하좌우 더 이상 이동할 수 있는 방향이 없음
     *             outOfBound가 true인 경우.
     * recursive case : 방문한 알파뱃 기록하며 상하좌우 이동.
     */
    void recursion(int row, int col, int cnt) {
        ans = Math.max(cnt, ans);
        for (int i = 0; i < 4; i++) {
            int nextRow = row + moveY[i];
            int nextCol = col + moveX[i];
            if (isOutOfBound(nextRow, nextCol)) continue;

            char nextAlpha = map[nextRow][nextCol];
            if (visited[nextAlpha - 'A']) continue;

            int route = 1 << (nextAlpha - 'A');
            if (routes[nextRow][nextCol] == (routes[row][col] | route)) continue;
            routes[nextRow][nextCol] = routes[row][col] | route;

            visited[nextAlpha - 'A'] = true;
            recursion(nextRow, nextCol, cnt + 1);
            visited[nextAlpha - 'A'] = false;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");

        r = Integer.parseInt(input1[0]);
        c = Integer.parseInt(input1[1]);

        map = new char[r][c];
        routes = new int[r][c];

        for (int i = 0; i < r; i++)
            map[i] = br.readLine().toCharArray();

        routes[0][0] = 1 << (map[0][0] - 'A');
        visited[map[0][0] - 'A'] = true;
        recursion(0, 0, 1);
        System.out.println(ans);
    }
}
