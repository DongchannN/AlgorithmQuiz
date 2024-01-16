package stack;

import java.util.*;
import java.io.*;

public class Boj_4949 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals(".")) break;
            char[] chars = input.toCharArray();
            Deque<Character> stack = new LinkedList<>();

            int exitCode = 0;
            for (char c : chars) {
                if (c == '(' || c == '[')
                    stack.offerFirst(c);
                else if (c == ')' || c == ']') {
                    if (c == ')' && !stack.isEmpty() && stack.peekFirst() == '(')
                        stack.pollFirst();
                    else if (c == ']' && !stack.isEmpty() && stack.peekFirst() == '[')
                        stack.pollFirst();
                    else {
                        exitCode = -1;
                        break;
                    }
                }
            }
            if (exitCode == -1 || !stack.isEmpty()) System.out.println("no");
            else System.out.println("yes");
        }
    }
}
