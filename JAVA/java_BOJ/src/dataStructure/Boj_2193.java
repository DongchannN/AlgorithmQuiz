package dataStructure;

import java.util.Scanner;

public class Boj_2193 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] dp = new long[n+2];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);
    }
}
