package dataStructure;

import java.util.Scanner;

public class Boj_15988 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int arrSize = scanner.nextInt();
        int[] input = new int[arrSize];

        for(int i = 0; i < arrSize; i++) {
            input[i] = scanner.nextInt();
        }

        int inputMax = getMax(input);
        long[] dp = new long[inputMax+3];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i <= inputMax; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1_000_000_009;
        }

        for(int i = 0; i < arrSize; i++) {
            System.out.println(dp[input[i]]);
        }
    }

    static int getMax(int[] arr) {
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(max < arr[i]) max = arr[i];
        }
        return max;
    }
}
