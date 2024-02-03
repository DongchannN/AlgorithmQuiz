package divideAndConquer;

import java.io.*;
import java.util.*;

public class Boj_1780 {

    int[] cnt = new int[3];
    int[][] map;

    boolean canCutPaper(int row, int col, int size) {
        int num = map[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[i][j] != num) return false;
            }
        }
        cnt[num + 1]++;
        return true;
    }

    void cutPaper(int row, int col, int size) {
        if (canCutPaper(row, col, size)) return ;


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int nextRow = row + ((size / 3) * i);
                int nextCol = col + ((size / 3) * j);
                cutPaper(nextRow, nextCol, size / 3);
            }
        }
    }

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] readLine = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(readLine[j]);
            }
        }

        cutPaper(0, 0, n);
        for (int i = 0; i < 3; i++)
            System.out.println(cnt[i]);
    }
}
