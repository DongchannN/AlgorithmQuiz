package backtracking;

import java.io.*;
import java.util.*;

public class Boj_2580 {
    static int[][] map = new int[9][9];

    static boolean checkVertical(int num, int col) {
        for (int i = 0; i < 9; i++) {
            if (num == map[i][col])
                return false;
        }
        return true;
    }

    static boolean checkHorizontal(int num, int row) {
        for (int i = 0; i < 9; i++) {
            if (num == map[row][i])
                return false;
        }
        return true;
    }

    static boolean checkBox(int num, int row, int col) {
        if (0 <= row && row <= 2) row = 0;
        else if (3 <= row && row <= 5) row = 3;
        else row = 6;

        if (0 <= col && col <= 2) col = 0;
        else if (3 <= col && col <= 5) col = 3;
        else col = 6;

        int r = row;
        int c = col;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (num == map[r][c]) return false;
                c++;
            }
            r++;
            c= col;
        }
        return true;
    }

    static void printMap() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.printf("%d ", map[i][j]);
            }
            System.out.println();
        }
    }
    static void recursion(int row, int col) {
        int nextRow;
        int nextCol;
        if (col == 8) {
            nextRow = row + 1;
            nextCol = 0;
        } else {
            nextRow = row;
            nextCol = col + 1;
        }

        if (row > 8 || col > 8) {
            printMap();
            System.exit(0);
        }
        if (map[row][col] != 0) {
            recursion(nextRow, nextCol);
            return ;
        }

        for (int i = 1; i <= 9; i++) {
            if (!checkBox(i, row, col)
                    || !checkVertical(i, col)
                    || !checkHorizontal(i, row)) continue;
            map[row][col] = i;

            recursion(nextRow, nextCol);
            map[row][col] = 0;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        recursion(0, 0);
    }
}
