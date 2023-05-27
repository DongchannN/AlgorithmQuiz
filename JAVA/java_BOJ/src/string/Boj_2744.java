package string;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2744 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.next();
        char[] strArr = inputStr.toCharArray();
        for (char c : strArr) {
            if (65 <= (int) c && (int) c <= 90) { // 대문자인 경우
                int i = (int) c + 32;
                c = (char) i;
                System.out.print(c);
            } else if (97 <= (int) c && (int) c <= 122) {
                int i = (int) c - 32;
                c = (char) i;
                System.out.print(c);
            }
        }
    }
}
