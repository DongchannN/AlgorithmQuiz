package accSum;

import java.util.*;
import java.io.*;

public class Boj_17232 {
    static int k;
    static int m;
    static int n;
    static char[][] map;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        int t = Integer.parseInt(s[2]);

        String[] s1 = br.readLine().split(" ");
        k = Integer.parseInt(s1[0]);
        int a = Integer.parseInt(s1[1]);
        int b = Integer.parseInt(s1[2]);

        map = new char[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++)
                map[i][j] = chars[j - 1];
        }

        for (int tc = 0; tc < t; tc++){
            int[][] accMap = getAccArr(map);
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= m; j++) {
                    int cnt = countNearLife(accMap, i, j);
                    if (map[i][j] == '*') {
                        cnt--;
                        if (cnt < a || cnt > b)
                            map[i][j] = '.';
                    } else if (a < cnt && cnt <= b)
                        map[i][j] = '*';
                }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++)
                System.out.printf("%c", map[i][j]);
            System.out.println();
        }
    }

    int[][] getAccArr(char[][] map) {
        int[][] acc = new int[map.length][map[0].length];
        for (int i = 1; i < map.length; i++)
            for (int j = 1; j < map[0].length; j++)
                acc[i][j] = acc[i -1][j] + acc[i][j - 1] - acc[i -1][j- 1] + (map[i][j] == '*' ? 1 : 0);
        return acc;
    }

    int countNearLife(int[][] acc, int row, int col) {
        int r1 = Math.max(row - k, 1);
        int r2 = Math.min(row + k, acc.length - 1);
        int c1 = Math.max(col - k, 1);
        int c2 = Math.min(col + k, acc[0].length - 1);
        return (acc[r2][c2] - acc[r2][c1 - 1] - acc[r1 - 1][c2] + acc[r1 - 1][c1 - 1]);
    }
}
