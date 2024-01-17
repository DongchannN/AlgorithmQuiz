package stack;

import java.util.*;
import java.io.*;

public class Boj_5397 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            Deque<Character> stackLeft = new LinkedList<>();
            Deque<Character> stackRight = new LinkedList<>();

            String[] inputs = br.readLine().split("");
            for (String input : inputs){
                if (input.equals("-"))
                    stackLeft.pollFirst();
                else if (input.equals("<")) {
                    if (!stackLeft.isEmpty())
                        stackRight.offerFirst(stackLeft.pollFirst());
                } else if (input.equals(">")) {
                    if (!stackRight.isEmpty())
                        stackLeft.offerFirst(stackRight.pollFirst());
                } else {
                    stackLeft.offerFirst(input.charAt(0));
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!stackLeft.isEmpty())
                sb.append(stackLeft.pollLast());
            while (!stackRight.isEmpty())
                sb.append(stackRight.pollFirst());
            System.out.println(sb.toString());
        }
    }
}
