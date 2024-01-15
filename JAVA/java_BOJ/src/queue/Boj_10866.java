package queue;

import java.io.*;
import java.util.*;

public class Boj_10866 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> queue = new LinkedList<>();
        int size = 0;
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            String cmd = inputs[0];

            if (cmd.equals("push_front")) {
                queue.add(0, Integer.parseInt(inputs[1]));
                size++;
            } else if (cmd.equals("push_back")) {
                queue.add(size, Integer.parseInt(inputs[1]));
                size++;
            } else if (cmd.equals("pop_front")) {
                int popped = -1;
                if (size != 0) {
                    popped = queue.remove(0);
                    size--;
                }
                System.out.println(popped);
            } else if (cmd.equals("pop_back")) {
                int popped = -1;
                if (size != 0) {
                    popped = queue.remove(size - 1);
                    size--;
                }
                System.out.println(popped);
            } else if (cmd.equals("size")) {
                System.out.println(size);
            } else if (cmd.equals("empty")) {
                if (size == 0)
                    System.out.println("1");
                else System.out.println("0");
            } else if (cmd.equals("front")) {
                int num = -1;
                if (size != 0) num = queue.get(0);
                System.out.println(num);
            } else if (cmd.equals("back")) {
                int num = -1;
                if (size != 0) num = queue.get(size - 1);
                System.out.println(num);
            }
        }
    }
}
