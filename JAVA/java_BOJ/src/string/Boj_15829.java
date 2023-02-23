package string;

import java.util.*;

public class Boj_15829 {
    static int r = 31;
    static int m = 1234567891;
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        String input = scanner.next();
        Long[] numList = new Long[len];
        for (int i = 0; i < len; i++) {
            int ascii = input.charAt(i);
            numList[i] =(long) ascii - 96;
        }

        long ans = 0;
        for (int i = 0; i < len; i++) {
            numList[i] = (numList[i] * (long) Math.pow(r, i)) % m;
            ans = (ans + numList[i]) % m;
        }

        System.out.println(ans);
    }
}
