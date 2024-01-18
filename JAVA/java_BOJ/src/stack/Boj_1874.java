package stack;

import java.io.*;
import java.util.*;

public class Boj_1874 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();

//        String s = "";
//        while (!(s = br.readLine()).equals(""))
//            arr.add(Integer.parseInt(s));

        while (true) {
            String s = br.readLine();
            if (s == null || s.equals("")) break;
            arr.add(Integer.parseInt(s));
        }

        Deque<Integer> stack = new LinkedList<>();
        List<Character> ans = new ArrayList<>();
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            stack.offerFirst(i);
            ans.add('+');
            while (stack.peekFirst() != null && idx < arr.size()) {
                if (Objects.equals(arr.get(idx), stack.peekFirst())) {
                    stack.pollFirst();
                    ans.add('-');
                    idx++;
                } else break;
            }
        }

        if (idx == arr.size()) {
            for (Character an : ans) System.out.println(an);
        } else System.out.println("NO");
    }
}
