package dataStructure;

import java.util.Scanner;

public class Boj_1149 {
    public void solution() {

        Scanner scanner = new Scanner(System.in);
        int arrSize = scanner.nextInt();
        int[][] colorCost = new int[arrSize][3];
        int[][] totalCost = new int[arrSize][3];

        //집의 가격 입력
        for (int i = 0; i < arrSize; i++) {
            for (int j = 0; j < 3; j++) {
                colorCost[i][j] = scanner.nextInt();

                if(i == 0) totalCost[i][j] = colorCost[i][j];
            }
        }

        for (int i = 1; i < arrSize; i++) {
            totalCost[i][0] = Math.min(totalCost[i - 1][1], totalCost[i - 1][2]) + colorCost[i][0];
            totalCost[i][1] = Math.min(totalCost[i - 1][0], totalCost[i - 1][2]) + colorCost[i][1];
            totalCost[i][2] = Math.min(totalCost[i - 1][1], totalCost[i - 1][0]) + colorCost[i][2];
        }

        int minCost = findArrMin(totalCost[arrSize - 1]);
        System.out.println(minCost);
    }

    static int findArrMin(int[] arr) {
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if(min > arr[i]) min = arr[i];
        }
        return min;
    }

}
