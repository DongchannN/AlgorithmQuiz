package dataStructure;

import java.util.Scanner;

public class Boj_9465 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        int[] ans = new int[testCase]; //케이스 별 답을 저장할 배열.

        for (int i = 0; i < testCase; i++) {
            int n = scanner.nextInt();

            int[][] Dp = new int[n+2][2];
            int[] upArr = new int[n+2];
            int[] downArr = new int[n+2];

            //점수 입력
            for (int j = 0; j < n; j++) {
                upArr[j] = scanner.nextInt();
            }
            for (int j = 0; j < n; j++) {
                downArr[j] = scanner.nextInt();
            }

            /**
             * Dp[n][0] - 위에서 고른 카드가 마지막일 때 최댓값.
             * Dp[n][1] - 아래에서 고른 카드가 마지막일 때 최댓값.
             *
             * Dp[n][0] - Dp[n-2]중 최댓값과 지금의 카드를 더한 값, Dp[n-1][1] 과 지금의 카드를 더한 값 비교.
             * Dp[n][1] - Dp[n-2]중 최댓값과 지금의 카드를 더한 값, Dp[n-1][0] 과 지금의 카드를 더한 값 비교.
             */
            Dp[0][0] = upArr[0];
            Dp[0][1] = downArr[0];
            Dp[1][0] = upArr[1] + downArr[0];
            Dp[1][1] = downArr[1] + upArr[0];


            for (int j = 2; j < n; j++) {
                Dp[j][0] = Math.max(upArr[j] + Dp[j - 1][1], upArr[j] + Math.max(Dp[j - 2][0], Dp[j - 2][1]));
                Dp[j][1] = Math.max(downArr[j] + Dp[j - 1][0], downArr[j] + Math.max(Dp[j - 2][0], Dp[j - 2][1]));
            }

            ans[i] = Math.max(Dp[n-1][0], Dp[n-1][1]);
        }

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }

}
