package divideAndConquer;

import java.io.*;
import java.util.*;

public class Boj_1992 {

    int[][] map;
    int n;

    StringBuilder sb = new StringBuilder();

    int canCompress(int row, int col, int size) {
        int num = map[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (num != map[i][j]) return -1;
            }
        }
        return num;
    }

    int[] getNextRowAndCol(int row, int col, int size, int info) {
        int[] ret = new int[2];
        int nextRow, nextCol;
        if (info == 0) {
            nextRow = row;
            nextCol = col;
        } else if (info == 1) {
            nextRow = row;
            nextCol = col + (size / 2);
        } else if (info == 2) {
            nextRow = row + (size / 2);
            nextCol = col;
        } else {
            nextRow = row + (size / 2);
            nextCol = col + (size / 2);
        }
        ret[0] = nextRow;
        ret[1] = nextCol;
        return ret;
    }

    void compress(int row, int col, int size) {
        int ret = canCompress(row, col, size);

        // 압축이 가능한 경우
        if (ret != -1) {
            sb.append(ret);
            return ;
        }

        // 압축이 불가능한 경우 4분할해서 다시 압축 가능한지 확인해야 함.
        sb.append("(");
        for (int i = 0; i < 4; i++) {
            // i = 0 -> 1사분면, i = 1 -> 2사분면, i = 2 -> 3사분면, i = 3 -> 4사분면
            int[] info = getNextRowAndCol(row, col, size, i);
            int nextRow = info[0];
            int nextCol = info[1];
            compress(nextRow, nextCol, size / 2);
        }
        sb.append(")");
    }

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] readLine = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(readLine[j]);
            }
        }

        compress(0, 0, n);

        System.out.println(sb.toString());
    }
}
