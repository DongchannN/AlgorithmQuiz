package dataStructure;

import java.util.Scanner;

public class Boj_2225 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int divide = scanner.nextInt();
        long[][] dp = new long[number+1][divide+1];

        for(int i = 1; i <= number; i++) {
            dp[i][1] = 1;
        }
        for(int i = 2; i <= divide; i++) {
            dp[1][i] = (long)i;
        }

        for(int i = 2; i <= number; i++) {
            for(int j = 2; j <= divide; j++) {
                if(i == j) {
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j-1]*2) % 1000000000;
                }else {
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000000;
                }
            }
        }

        System.out.println(dp[number][divide]);
    }
}
