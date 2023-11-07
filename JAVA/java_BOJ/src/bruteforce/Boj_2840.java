package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2840 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int size = Integer.parseInt(s[0]);
        int num = Integer.parseInt(s[1]);

        int[] checkDouble = new int[30];

        char[] ret = new char[size];
        for (int i = 0; i < size; i++) {
            ret[i] = '?';
        }

        int idx = 0;
        for (int i = 0; i < num; i++) {
            String[] s2 = br.readLine().split(" ");
            int move = Integer.parseInt(s2[0]);
            char c = s2[1].charAt(0);

            idx = (idx + move) % size;
            if (ret[idx] != '?' && ret[idx] != c) {
                System.out.println("!");
                return;
            }
            ret[idx] = c;
        }

        for (int i = 0; i < size; i++) {
            if (ret[i] != '?' && ++checkDouble[ret[i] - 65] > 1) {
                System.out.println("!");
                return;
            }
        }

        for (int i = 0; i < size; i++) {
            idx = (idx + size) % size;
            System.out.printf("%c", ret[idx]);
            idx--;
        }
        System.out.println();
    }
}
