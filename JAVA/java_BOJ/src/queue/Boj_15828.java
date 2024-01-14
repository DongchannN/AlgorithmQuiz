package queue;

import java.io.*;
import java.util.*;

public class Boj_15828 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int len = 0;

        Queue<Integer> q = new LinkedList<>();
        while (true) {
            int input = Integer.parseInt(br.readLine());
            if (input == -1) break;
            else if (input > 0 && n > len) {
                q.add(input);
                len++;
            } else if (input == 0 && len > 0) {
                q.remove();
                len--;
            }
        }
        if (len == 0) System.out.print("empty");
        for (int i = 0; i < len; i++) {
            System.out.printf("%d ", q.remove());
        }
        System.out.println();
    }
}
