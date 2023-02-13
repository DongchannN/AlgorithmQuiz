package bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj_14500 {
    static int n;
    static int m;
    static int[][] board;

    static boolean[][] visited;

    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {-1, 1, 0, 0};

    static int ans;
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[2];
        for (int i = 0; i < 2; i++) {
            arr[i] = scanner.nextInt();
        }
        n = arr[0];
        m = arr[1];
        board = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = scanner.nextInt();
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < arr[0]; i++) {
            for (int j = 0; j < arr[1]; j++) {
                visited[i][j] = true;
                searchRoute(i,j,board[i][j], 0);
                visited[i][j] = false;
            }
        }
        System.out.println(ans);

    }

    public static void searchRoute(int y, int x, int sum, int cnt) {
        if (cnt >= 3) {
            ans = Math.max(sum, ans);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nowY = y + moveY[i];
            int nowX = x + moveX[i];

            if (nowY >= n || nowX >= m || nowY < 0 || nowX < 0) {
                continue;
            }
            if (!visited[nowY][nowX]) {

                if (cnt == 1) {
                    visited[nowY][nowX] = true;
                    searchRoute(y, x, sum + board[nowY][nowX], cnt+1);
                    visited[nowY][nowX] = false;
                }
                visited[nowY][nowX] = true;
                searchRoute(nowY, nowX, sum + board[nowY][nowX], cnt+1);
                visited[nowY][nowX] = false;
            }
        }
    }
}
