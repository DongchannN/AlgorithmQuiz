package dataStructure;

import java.util.Scanner;
import java.lang.ArithmeticException;
public class Boj_11726 {
    public void solution() throws ArithmeticException {
        Scanner scanner = new Scanner(System.in);
        long inputNumber = scanner.nextInt();
        long small, big;
        long maxBig = inputNumber / 2;

        long count = 1;
        for(big = 1; big <= maxBig; big++) {
            small = inputNumber - (2 * big);

            long countingNumber = factorial(small + big) / (factorial(small) * factorial(big));

            count += countingNumber;
        }

        System.out.println(count % 10007);
    }

    private long factorial(long number) {
        long output = 1;
        for (long i = number; i > 0; i--) {
            output *= i;
        }
        if (output == 0) {
            output = 1;
        }
        return output;
    }
}
