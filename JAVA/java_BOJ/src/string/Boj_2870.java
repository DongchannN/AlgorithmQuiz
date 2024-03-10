package string;

import java.io.*;
import java.util.*;

public class Boj_2870 {

    String atoi(Queue<Character> buffer) {
        StringBuilder sb = new StringBuilder();
        int len = 0;
        while (!buffer.isEmpty()) {
            char n = buffer.poll();
            if (n == '0' && len == 0) continue;
            sb.append(n);
            len++;
        }
        if (len == 0) return "0";
        return sb.toString();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] words = new String[n];
        for (int i = 0; i < n; i++)
            words[i] = br.readLine();

        List<String> numbers = new ArrayList<>();
        Queue<Character> buffer = new LinkedList<>();
        for (String str : words) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if ('0' <= c && c <= '9') {
                    buffer.offer(c);
                } else {
                    if (!buffer.isEmpty()) numbers.add(atoi(buffer));
                }
            }
            if (!buffer.isEmpty()) numbers.add(atoi(buffer));
        }

        numbers.sort((a, b) -> {
            if (a.length() != b.length()) return a.length() - b.length();
            else return a.compareTo(b);
        });

        for (String num : numbers)
            System.out.println(num);
    }
}
