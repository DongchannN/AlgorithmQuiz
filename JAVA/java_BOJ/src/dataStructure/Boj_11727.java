package dataStructure;

import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigInteger;

public class Boj_11727 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ans = countingNumber(n);

        System.out.println(ans);
    }
    private int countingNumber(int width) {
        int[] arr = new int[1001];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 3;
        for (int i = 3; i <= width; i++){
            arr[i] = (arr[i - 1] + (2 * arr[i - 2])) % 10007;
        }
        return arr[width];
    }
}
