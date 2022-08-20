package dataStructure;

import java.util.List;
import java.util.Scanner;

public class Boj_11057 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        int[][] Dp = new int[num][];

        for (int i = 0; i < 10; i++) {
            Dp[1][i] = 1;
        }

        for (int i = 10; i >= 1; i--) {
            int j = 10 - i;
            Dp[2][j] = i;
        }

        for (int i = 2; i < num; i++) {
            for(int j = 0; j < 10; j++){
                for (int k = j; k < 10; k++) {
                    Dp[i][j] += Dp[i - 1][k];
                }
            }
        }

        int ans = addList(Dp[num]);
    }

    static int addList(int[] list) {
        int size = list.length;
        int add = 0;
        for (int i = 0; i < size; i++) {
            add += list[i];
        }
        return add;
    }
}
