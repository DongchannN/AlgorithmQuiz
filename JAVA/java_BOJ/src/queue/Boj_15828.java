package queue;

import java.io.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

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

    public void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedBlockingQueue<>(n);
        while (true) {
            int cmd = Integer.parseInt(br.readLine());
            if (cmd > 0)
                q.offer(cmd);
            else if (cmd == 0)
                q.poll();
            else break;
        }
        if (q.size() == 0) {
            System.out.println("empty");
        } else {
            while (!q.isEmpty())
                System.out.print(q.poll() + " ");
            System.out.println();
        }
    }
}
