package dataStructure;

import java.util.Scanner;

public class Boj_10844 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        long[][] dp = new long[10][input + 2];
        for(int i = 1; i < 10; i++) {
            dp[i][1] = 1;
            dp[i][2] = 2;
        }
        dp[9][2] = 1;

        for(int i = 3; i <= input; i++) {
            dp[1][i] = (dp[1][i-2] + dp[2][i-1]) % 1000000000;
            for(int k = 2; k < 9; k++) {
                dp[k][i] = (dp[k-1][i-1] + dp[k+1][i-1]) % 1000000000;
            }
            dp[9][i] = (dp[8][i-1]) % 1000000000;
        }

        long ans = 0;
        for(int i = 1; i < 10; i++) {
            ans += (dp[i][input]);
        }
        System.out.println(ans % 1000000000);
    }

}
