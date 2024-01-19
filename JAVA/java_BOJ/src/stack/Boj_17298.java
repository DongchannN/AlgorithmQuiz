package stack;

import java.io.*;
import java.util.*;

public class Boj_17298 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] strArr = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(strArr[i]);

        int[] ans = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            int now = arr[i];
            while (true) {
                if (stack.isEmpty()) {
                    ans[i] = -1;
                    break;
                }
                int peek = stack.peekFirst();
                if (peek > now) {
                    ans[i] = peek;
                    break;
                } else {
                    stack.pollFirst();
                }
            }
            stack.offerFirst(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : ans)
            sb.append(i + " ");
        System.out.println(sb.toString());
    }
}
