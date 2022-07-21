package dataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Boj_1912 {
    static int[] dp;
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int arrSize = scanner.nextInt();
        int[] arr = new int[arrSize];

        dp = new int[arrSize];

        for(int i = 0; i < arrSize; i++) {
            arr[i] = scanner.nextInt();
        }

        dp[0] = arr[0];

        for(int i = 1; i < arrSize; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
        }

        int max = dp[0];
        for(int i = 1; i < arrSize; i++) {
            if(dp[i] > max) max = dp[i];
        }
        System.out.println(max);
    }
}
