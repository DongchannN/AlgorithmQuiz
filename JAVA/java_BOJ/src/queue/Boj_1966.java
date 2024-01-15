package queue;

import java.io.*;
import java.util.*;

public class Boj_1966 {

    static class Print {
        int id;
        int priority;

        private Print(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }

    Queue<Print> initPrintQueue(int n, List<Integer> priorityArr) {
        Queue<Print> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            q.add(new Print(i, priorityArr.get(i)));
        return q;
    }

    boolean canPrint(int priority, Queue<Print> q) {
        for (Print p : q) {
            if (p.priority > priority)
                return false;
        }
        return true;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            List<Integer> priorityArr = new LinkedList<>();
            String[] inputArr = br.readLine().split(" ");
            
            for (int i = 0; i < n; i++)
                priorityArr.add(Integer.parseInt(inputArr[i]));

            int popCnt = 0;
            int ans = -1;
            Queue<Print> q = initPrintQueue(n, priorityArr);
            while (!q.isEmpty()) {
                if (!canPrint(q.peek().priority, q)) {
                    q.add(q.remove());
                } else {
                    Print popped = q.remove();
                    popCnt++;
                    if (popped.id == m) {
                        ans = popCnt;
                        break;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
