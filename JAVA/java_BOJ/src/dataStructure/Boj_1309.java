package dataStructure;

import java.util.Scanner;

public class Boj_1309 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        long[] arr = new long[num + 1];

        arr[0] = 3;
        arr[1] = 7;

        for (int i = 2; i < num; i++) {
            arr[i] = (arr[i - 1] * 2 + arr[i - 2]) % 9901;
        }

        System.out.println(arr[num-1] % 9901);
    }
}
