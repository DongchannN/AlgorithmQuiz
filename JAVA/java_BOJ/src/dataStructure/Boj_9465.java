package dataStructure;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj_9465 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        int[] upperArr;
        int[] downArr;

        for (int i = 0; i < testCase; i++) {
            int n = scanner.nextInt();
            upperArr = new int[n];
            downArr = new int[n];
            for (int j = 0; j < n; j++) {
                upperArr[j] = scanner.nextInt();
            }
            for (int j = 0; j < n; j++) {
                downArr[j] = scanner.nextInt();
            }

            int[] Dp = new int[n];

            Dp[0] = Math.max(upperArr[0], downArr[0]);

            for (int j = 1; j < n; j++) {
                ArrayList<Integer> compareArr = new ArrayList<>();

                int highValue = Math.max(upperArr[j], downArr[j]);

                compareArr.add(highValue);
                compareArr.add(Dp[j-1]);
            }
        }


    }
}
