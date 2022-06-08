package dataStructure;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.ArithmeticException;
public class Boj_11726 {
    public void solution() throws ArithmeticException {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();

        long[] arr = new long[1001];

        arr[0] = 1;
        arr[1] = 2;

        for (int i = 2; i < inputNumber; i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % 10007;
        }



        System.out.println(arr[inputNumber-1]);
    }
}
