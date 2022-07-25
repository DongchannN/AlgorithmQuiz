package dataStructure;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj_1699 {

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int[] dp = new int[input+1];
        for(int i = 1; i <= input; i++) {
            int maxSqrtNum = (int)Math.sqrt(i);
            int[] compareArr = new int[maxSqrtNum];
            for(int j = 1; j <= maxSqrtNum; j++) {
                int beforeNum = i - pow(j);
                compareArr[j-1] = 1 + dp[beforeNum];
            }
            dp[i] = getMinArr(compareArr);
        }
        System.out.println(dp[input]);
    }


    int pow(int n) {
        return n*n;
    }

    int getMinArr(int[] arr) {
        int min = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(min > arr[i]) min = arr[i];
        }
        return min;
    }
}
