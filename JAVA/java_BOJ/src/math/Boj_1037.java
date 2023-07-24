package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Boj_1037 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        int[] arr = new int[number];
        for (int i = 0; i < number; i++) {
            arr[i] = scanner.nextInt();
        }

        long minNum = Arrays.stream(arr).min().getAsInt();
        long maxNum = Arrays.stream(arr).max().getAsInt();

        System.out.println(minNum * maxNum);
    }
}
