package dataStructure;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj_1932 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        int[][] arr = new int[size+1][];

        for (int i = 0; i < size+1; i++) {
            arr[i] = new int[i + 1];
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int[][] Dp = new int[size+1][size+1];

        Dp[0][0] = arr[0][0];
        Dp[1][0] = Dp[0][0] + arr[1][0];
        Dp[1][1] = Dp[0][0] + arr[1][1];

        for (int i = 2; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    Dp[i][j] = Dp[i - 1][j] + arr[i][j];
                } else if (j == i) {
                    Dp[i][j] = Dp[i - 1][j - 1] + arr[i][j];
                } else {
                    Dp[i][j] = Math.max(Dp[i - 1][j - 1], Dp[i - 1][j]) + arr[i][j];
                }
            }
        }

        System.out.println(getMax(Dp[size - 1]));
    }

    static int getMax(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        return max;
    }
}
