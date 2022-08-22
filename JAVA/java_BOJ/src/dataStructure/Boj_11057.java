package dataStructure;

import java.util.List;
import java.util.Scanner;

public class Boj_11057 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        long[][] Dp = new long[num+2][10];

        for (int i = 0; i < 10; i++) {
            Dp[1][i] = 1;
        }

//        for (int i = 10; i >= 1; i--) {
//            int j = 10 - i;
//            Dp[2][j] = i;
//        }

        for (int i = 2; i <= num; i++) {
            for (int j = 0; j < 10; j++) {
                long sum = 0;
                for (int k = j; k < 10; k++) {
                    sum = (sum + Dp[i - 1][k]) % 10007;
                }
                sum %= 10007;
                Dp[i][j] = sum;
            }
        }

        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans = (ans + Dp[num][i]) % 10007;
        }

        System.out.println(ans % 10007);
    }

}
