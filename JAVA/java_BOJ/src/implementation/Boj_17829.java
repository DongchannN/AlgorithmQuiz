package implementation;

import java.io.*;
import java.util.*;

public class Boj_17829 {
    static int[][] map;
    static int[][] map2;

    static void compressMap(int size) {
        int n = size / 2;
        map2 = new int[n][n];
        int[] arr = new int[4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[0] = map[i * 2][j * 2];
                arr[1] = map[i * 2][(j * 2) + 1];
                arr[2] = map[(i * 2) + 1][j * 2];
                arr[3] = map[(i * 2) + 1][(j * 2) + 1];
                Arrays.sort(arr);
                map2[i][j] = arr[2];
            }
        }

        map = map2;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(line[j]);
        }

        while (n > 1) {
            compressMap(n);
            n /= 2;
        }
        System.out.println(map[0][0]);
    }
}
