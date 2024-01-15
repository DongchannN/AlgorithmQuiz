package queue;

import java.io.*;
import java.util.*;

public class Boj_5430 {
    String listToPrintForm(Deque<Integer> queue, int flag) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (flag == 1) {
            while (!queue.isEmpty()) {
                sb.append(queue.pollLast());
                if (!queue.isEmpty()) sb.append(",");
            }
        } else if (flag == 0){
            while (!queue.isEmpty()) {
                sb.append(queue.pollFirst());
                if (!queue.isEmpty()) sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            char[] commands = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                deque.offer(Integer.parseInt(st.nextToken()));
            }


            int flag = 0;
            int exitCode = 0;
            for (char cmd : commands) {
                if (cmd == 'R') {
                    if (flag == 0) flag = 1;
                    else flag = 0;
                } else if (cmd == 'D' && deque.isEmpty()) {
                    exitCode = -1;
                    break;
                } else if (cmd == 'D') {
                    if (flag == 0) deque.pollFirst();
                    else deque.pollLast();
                }
            }

            if (exitCode == -1) {
                bw.write("error\n");
            } else {
                String out = listToPrintForm(deque, flag);
                bw.write(out);
                bw.write("\n");
            }
            bw.flush();
        }
        bw.close();
    }
}
