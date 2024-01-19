package stack;

import java.io.*;
import java.util.*;

public class Boj_2841 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int p = Integer.parseInt(inputs[1]);

        Deque<Integer>[] stack = new LinkedList[n];
        for (int i = 0; i < n; i++)
            stack[i] = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int lineNum = Integer.parseInt(input[0]);
            int platNum = Integer.parseInt(input[1]);

            while (true) {
                if (stack[lineNum - 1].peekFirst() == null) {
                    stack[lineNum - 1].offerFirst(platNum);
                    cnt++;
                    break;
                }
                int peeked = stack[lineNum - 1].peekFirst();
                if (peeked < platNum) {
                    stack[lineNum - 1].offerFirst(platNum);
                    cnt++;
                    break;
                } else if (peeked > platNum) {
                    stack[lineNum - 1].pollFirst();
                    cnt++;
                } else break;
            }
        }
        System.out.println(cnt);
    }
}
