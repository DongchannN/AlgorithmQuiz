package stack;

import java.io.*;
import java.util.*;

public class Boj_16120 {

    boolean checkCanPPAP(Deque<Character> stack) {
        char[] temp = new char[4];
        StringBuilder sb = new StringBuilder();
        for (int i = 3; i >= 0; i--)
            sb.append(stack.pollLast());
        String s = sb.reverse().toString();
        for (int i = 0; i < 4; i++)
            stack.offerLast(s.charAt(i));
        return s.equals("PPAP");
    }

    void convertPPAPToP(Deque<Character> stack) {
        for (int i = 0; i < 4; i++)
            stack.pollLast();
        stack.offerLast('P');
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Deque<Character> stack = new LinkedList<>();

        for (char c : arr) {
            stack.offerLast(c);
            if (stack.size() < 4) continue;

            if (checkCanPPAP(stack)) {
                convertPPAPToP(stack);
            }
        }
        if (stack.size() == 1 && stack.peekFirst().equals('P'))
            System.out.println("PPAP");
        else System.out.println("NP");
    }
}
