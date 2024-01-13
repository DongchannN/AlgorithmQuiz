package array;

import java.io.*;
import java.util.*;

public class Boj_1406 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<String> arr = new LinkedList<>();
        for (int i = 0; i < str.length(); i++)
            arr.add(String.valueOf(str.charAt(i)));

        int n = Integer.parseInt(br.readLine());
        ListIterator<String> iter = arr.listIterator(str.length());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String cmd = input[0];

            if (cmd.equals("L")) {
                if (iter.hasPrevious())
                    iter.previous();
            } else if (cmd.equals("D")) {
                if (iter.hasNext())
                    iter.next();
            } else if (cmd.equals("B")) {
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            } else if (cmd.equals("P")) {
                iter.add(input[1]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : arr)
            sb.append(s);
        System.out.println(sb.toString());
    }
}
