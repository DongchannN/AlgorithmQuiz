package recursion;

import java.io.*;
import java.util.*;

public class Boj_6603 {

    static int[] arr;
    static boolean[] visited;
    static List<Integer> output;
    int n;

    void makeLotto(int depth, int beforeIdx) {
        if (depth == 6) {
            for (int i : output)
                System.out.printf("%d ", i);
            System.out.println();
            return ;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && beforeIdx < i) {
                output.add(arr[i]);
                visited[i] = true;
                int idx = output.size() - 1;

                makeLotto(depth + 1, i);

                output.remove(idx);
                visited[i] = false;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            if (n == 0) break;

            arr = new int[n];
            visited = new boolean[n];
            output = new ArrayList<>();

            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input[i + 1]);

            makeLotto(0, -1);
            System.out.println();
        }
    }
}
