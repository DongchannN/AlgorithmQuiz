package dataStructure;

import java.util.Scanner;

public class Boj_11053 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int arrSize = scanner.nextInt();
        int[] arr = new int[arrSize];
        int[] dp = new int[arrSize];

        for(int i = 0; i < arrSize; i++) {
            arr[i] = scanner.nextInt();
        }
        dp[0] = 1;
        for(int i = 1; i < arrSize; i++) {
            dp[i] = 1;
            for(int j = i-1; j >= 0; j--) {
                if(arr[i] > arr[j] && dp[i] < dp[j]+1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        System.out.println(max(dp));
    }

    static int max(int[] arr) {
        int maxNum = arr[0];
        if(arr.length == 1) return maxNum;
        for(int i = 1; i < arr.length; i++) {
            if(maxNum < arr[i]) maxNum = arr[i];
        }
        return maxNum;
    }
}

