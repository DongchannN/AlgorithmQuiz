package math;

import java.io.*;
import java.util.*;

public class Boj_1564 {
    long makeBrief(long num) {
        while (num % 10 == 0) {
            num /= 10;
        }
        return (num % 1_000_000_000_000L);
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long num = 1;
        for (long i = 1; i <= n; i++) {
            num *= i;
            num = makeBrief(num);
        }
        String ans = String.valueOf(num % 100000);
        for (int i = 0; i < 5 - ans.length(); i++)
            System.out.print("0");
        System.out.println(ans);
    }
}
