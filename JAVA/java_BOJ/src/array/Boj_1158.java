package array;

import java.io.*;
import java.util.*;

public class Boj_1158 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add(i + 1);

        System.out.print("<");
        int i = k - 1;
        while (!arr.isEmpty()) {
            i %= arr.size();
            System.out.printf("%d", arr.get(i));
            arr.remove(i);
            i += (k - 1);
            if (!arr.isEmpty()) System.out.print(", ");
        }
        System.out.print(">\n");
    }
}
