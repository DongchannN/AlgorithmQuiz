package dataStructure;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj_9465 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        int[] ans = new int[testCase]; //케이스 별 답을 저장할 배열.

        for (int i = 0; i < testCase; i++) {
            int n = scanner.nextInt();

            int[] Dp = new int[n+2];
            int[] upArr = new int[n+2];
            int[] downArr = new int[n+2];

            //점수 입력
            for (int j = 0; j < n; j++) {
                upArr[j] = scanner.nextInt();
            }
            for (int j = 0; j < n; j++) {
                downArr[j] = scanner.nextInt();
            }

            Dp[0] = Math.max(upArr[0], downArr[0]);

            Dp[1] = Math.max(upArr[0] + downArr[1], downArr[0] + upArr[1]);
            for (int j = 2; j < n; j++) {
                int value;
                if (Dp[j - 1] == upArr[j - 1]) {
                    value = downArr[j];
                } else value = upArr[j];

                Dp[j] = Math.max(Dp[j - 1] + value, Dp[j - 2] + Math.max(downArr[j], upArr[j]));
            }

            ans[i] = Dp[n-1];
        }

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }

}
