package dataStructure;

import java.util.Scanner;

public class Boj_10844 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ans = countingNumber(n);

        System.out.println(ans);
    }

    private int countingNumber(int num) {
        int[] arr = new int[101];
        arr[1] = 9;
        arr[2] = 17;

        for (int i = 3; i <= num; i++) {
            arr[i] = ((arr[i-1] * 2) - (i-1)) % 1000000000;  // 1,000,000,000
        }
        return arr[num] % 1000000000;
    }
}
