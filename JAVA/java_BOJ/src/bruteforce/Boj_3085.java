package bruteforce;

import java.util.Objects;
import java.util.Scanner;

public class Boj_3085 {
    static int row;
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        String[][] inputArr = new String[row][row];

        for (int i = 0; i < row; i++) {
            inputArr[i] = scanner.next().split("");
        }

        int maxCount = 1;
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < row; k++) {
                //좌우 바꿈
                if (k < row -1){
                    String tmp = inputArr[i][k];
                    inputArr[i][k] = inputArr[i][k + 1];
                    inputArr[i][k + 1] = tmp;
                    int num = checkRoute(inputArr);
                    if (num > maxCount) {
                        maxCount = num;
                    }
                    tmp = inputArr[i][k];
                    inputArr[i][k] = inputArr[i][k + 1];
                    inputArr[i][k + 1] = tmp;
                }

                if(i < row - 1){
                    String tmp = inputArr[i][k];
                    inputArr[i][k] = inputArr[i + 1][k];
                    inputArr[i + 1][k] = tmp;
                    int num = checkRoute(inputArr);
                    if (num > maxCount) {
                        maxCount = num;
                    }
                    tmp = inputArr[i][k];
                    inputArr[i][k] = inputArr[i + 1][k];
                    inputArr[i + 1][k] = tmp;
                }
            }
        }
        System.out.println(maxCount);
    }

    public static int checkRoute(String[][] inputArr) {
        int count = 1;
        int maxCount = 1;
        for (int i = 0; i < row; i++) {
            count = 1;
            for (int k = 0; k < row-1; k++) {
                if (Objects.equals(inputArr[i][k], inputArr[i][k + 1])) {
                    count += 1;
                } else count = 1;

                if (count > maxCount) {
                    maxCount = count;
                }
            }

            count = 1;
            for (int j = 0; j < row-1; j++) {
                if (Objects.equals(inputArr[j][i], inputArr[j + 1][i])) {
                    count += 1;
                } else count = 1;

                if (count > maxCount) {
                    maxCount = count;
                }
            }
        }
        return maxCount;
    }

}