package dataStructure;

import java.util.Scanner;

public class Boj_14002 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int arrSize = scanner.nextInt();
        int[] arr = new int[arrSize];

        int[] dp = new int[arrSize];        //배열의 숫자가 가장 클 때의 수열의 길이.
        int[] indexArr = new int[arrSize];  //큰 수에서 작은수로 가는 다음 인덱스를 알려주는 배열.

        for (int i = 0; i < arrSize; i++) {
            arr[i] = scanner.nextInt();
            indexArr[i] = -1;               //indexArr -1로 초기화 (다음 수가 없다는 뜻)
        }

        dp[0] = 1;
        for (int i = 1; i < arrSize; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {  //조건 충족시 arr[i]의 배열이 arr[j]를 포함하고 있음.
                    dp[i] = dp[j] + 1;
                    indexArr[i] = j;                         //arr[i]의 전 숫자는 arr[j].
                }
            }
        }

        int maxDp = max(dp);
        int nowPoint;
        int nowIndex = -1;

        int[] printArr = new int[maxDp];   //가장 긴 수열 중 하나를 담는 배열.
        for(int i = 0; i < arrSize; i++) {
            if(dp[i] == maxDp) {
                nowPoint = arr[i];
                nowIndex = i;
                printArr[0] = nowPoint;    //printArr에 가장 큰 수 먼저 담기.
                break;
            }
        }

        for(int i = 1; i < maxDp; i++) {
            int nextIndex = indexArr[nowIndex];
            printArr[i] = arr[nextIndex]; //printArr에 그 다음 큰수 담기.
            nowIndex = nextIndex;
        }

        System.out.println(maxDp);
        for(int i = maxDp-1; i >= 0; i--) {
            System.out.printf("%d ", printArr[i]);
        }

    }

    static int max(int[] arr) {
        int maxNum = arr[0];
        if (arr.length == 1) return maxNum;
        for (int i = 1; i < arr.length; i++) {
            if (maxNum < arr[i]) maxNum = arr[i];
        }
        return maxNum;
    }
}
