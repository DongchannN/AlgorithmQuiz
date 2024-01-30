package recursion;

import java.util.*;
import java.io.*;

public class Boj_9663 {

    int[][] map;
    int n;
    int cnt = 0;

    boolean isValid(int row, int col) {
        int i = 1;
        while (true) {
            int flag = 0;
            if (col - i >= 0) {
                flag = 1;
                if (map[row][col - i] == 1) return false;
            }
            if (row - i >= 0 && col - i >= 0) {
                flag = 1;
                if (map[row - i][col - i] == 1) return false;
            }
            if (row + i < n && col - i >= 0) {
                flag = 1;
                if (map[row + i][col - i] == 1) return false;
            }
            i++;
            if (flag == 0) break;
        }
        return true;
    }

    void recursion(int col) {
        if (col == n) {
            cnt++;
            return;
        }

        for (int r = 0; r < n; r++) {
            if (isValid(r, col)) {
                map[r][col] = 1;
                recursion(col + 1);
                map[r][col] = 0;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        recursion(0);
        System.out.println(cnt);
    }
}
