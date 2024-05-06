package greedy;

import java.io.*;

public class Boj_1034 {
    static int row, col, k;
    static int[][] map;
    static boolean[] visitedRow;
    static int[] temp;

    static int countZeroInRow(int row) {
        int cnt = 0;
        for (int i = 0; i < col; i++) {
            if (map[row][i] == 0)
                cnt++;
        }
        return cnt;
    }

    static boolean compareRow(int row, int[] compare) {
        int[] compared = map[row];
        for (int i = 0; i < compare.length; i++) {
            if (compared[i] != compare[i])
                return false;
        }
        return true;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        row = Integer.parseInt(s[0]);
        col = Integer.parseInt(s[1]);

        temp = new int[col];
        visitedRow = new boolean[row];
        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            s = br.readLine().split("");
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        k = Integer.parseInt(br.readLine());

        int max = 0;
        for (int i = 0; i < row; i++) {
            if (visitedRow[i]) continue;
            int zeros = countZeroInRow(i);
            if (k % 2 != zeros % 2 || zeros > k) continue;
            int cnt = 1;
            for (int j = 0; j < col; j++) {
                temp[j] = map[i][j];
            }
            for (int j = i + 1; j < row; j++) {
                if (compareRow(j, temp)) {
                    cnt++;
                    visitedRow[j] = true;
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}
