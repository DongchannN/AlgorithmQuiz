package dataStructure;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj_9095 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        ArrayList<Integer> arrayList= new ArrayList<Integer>();
        for (int i = 0; i < T; i++){
            int input = scanner.nextInt();
            arrayList.add(i, input);
        }

        for (int i = 0; i < T; i++) {
            operator(arrayList.get(i));
        }

    }

    static void operator(int inputNumber) {
        int one, two, three;
        int maxThree = inputNumber / 3;

        int count = 0;
        for (three = 0; three <= maxThree; three++) {
            int maxTwo = (inputNumber - (three * 3)) / 2;
            for (two = 0; two <= maxTwo; two++) {
                one = inputNumber - (2 * two) - (3 * three);
                count += factorial(one + two + three) / (factorial(one) * factorial(two) * factorial(three));
            }
        }

        System.out.println(count);
    }
    static int factorial(int num) {
        if (num == 1) {
            return num;
        }else if (num == 0) return 1;
        return num * factorial(num - 1);
    }

}
