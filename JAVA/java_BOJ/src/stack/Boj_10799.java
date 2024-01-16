package stack;

import java.io.*;
import java.util.*;

public class Boj_10799 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Deque<Character> stack = new LinkedList<>();

        int ans = 0;
        int idx = 0;
        while (idx < arr.length) {
            if (arr[idx] == '(') {
                if (arr[idx + 1] == ')') {
                    ans += stack.size();
                    idx += 2;
                } else {
                    stack.offerFirst('(');
                    idx += 1;
                }
            } else {
                ans += 1;
                stack.pollFirst();
                idx += 1;
            }
        }
        System.out.println(ans);
    }
}
