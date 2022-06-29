package dataStructure;

import java.util.Scanner;

public class Boj_15990 {
    static long[][] dp;
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] input = new int[number];
        long[] output = new long[number];
        dp = new long[100001][4];
        for(int i = 0; i < number; i++) {
            input[i] = scanner.nextInt();
            if(dp[input[i]][1] != 0 ) {   //이미 연산된 경우는 바로 결과값에 넣음.
                output[i] = (dp[input[i]][1] + dp[input[i]][2] + dp[input[i]][3]) % 1000000009;
            }
            else{
                output[i] = numberingCase(input[i]);
            }
        }

        for(int i = 0; i < number; i++) {
            System.out.println(output[i]);
        }

    }

    static long numberingCase(int num) {
        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;

        dp[2][1] = 0;
        dp[2][2] = 1;
        dp[2][3] = 0;

        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        if(num >= 4) {
            for (int i = 4; i <= num; i++) {
                dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1000000009;
                dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1000000009;
                dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1000000009;
            }
        }
        long numberOfCase = (dp[num][1] + dp[num][2] + dp[num][3]) % 1000000009;
        return numberOfCase;
    }
}
