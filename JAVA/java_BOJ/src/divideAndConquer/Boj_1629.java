package divideAndConquer;

import java.io.*;
import java.util.*;

public class Boj_1629 {
    static int c;

    long doPow(long under, long upper) {
        if (upper == 1) return under % c;

        long divided = doPow(under, upper / 2);
        if (upper % 2 == 1) {
            return (((divided * divided) % c ) * under) % c;
        } else
            return (divided * divided) % c;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);

        System.out.println(doPow(a, b));
    }
}
