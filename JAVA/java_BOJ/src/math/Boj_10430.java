package math;

import java.util.Scanner;

public class Boj_10430 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int exp1 = (a + b) % c;
        int exp2 = ((a % c) + (b % c)) % c;
        int exp3 = (a * b) % c;
        int exp4 = ((a % c) * (b % c)) % c;

        System.out.println(exp1);
        System.out.println(exp2);
        System.out.println(exp3);
        System.out.println(exp4);
    }
}
