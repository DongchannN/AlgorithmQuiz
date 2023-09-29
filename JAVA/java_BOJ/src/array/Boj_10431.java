package array;

import java.util.Scanner;

public class Boj_10431 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);

        int tc = scanner.nextInt();

        for (int i = 0; i < tc; i++) {
            int[] arr = new int[21];
            for (int j = 0; j < 21; j++) {
                arr[j] = scanner.nextInt();
            }

            int cnt = 0;
            for (int a = 20; a > 0; a--) {
                int temp;
                for (int b = a; b > 0; b--) {
                    if (arr[a] < arr[b]) {
                        temp = arr[a];
                        arr[a] = arr[b];
                        arr[b] = temp;
                        cnt++;
                    }
                }
            }
            System.out.printf("%d %d\n", arr[0], cnt);
        }
    }
}
