package recursion;

import java.util.*;
import java.io.*;

public class Boj_1208 {

    static int s;
    static int[]arr;
    static long ans = 0;
    static int isLeft = 1;
    static Map<Integer, Integer> temp = new HashMap<>();

    static void recursion(int idx, int end, int sum) {
        if (idx == end) {
            if (isLeft == 1) {
                int cnt = temp.getOrDefault(sum, 0);
                temp.put(sum, cnt + 1);
            } else {
                int cnt = temp.getOrDefault(s - sum, 0);
                ans += cnt;
            }
            return ;
        }

        recursion(idx + 1, end, sum);
        recursion(idx + 1, end, sum + arr[idx]);
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");

        int n = Integer.parseInt(input1[0]);
        s = Integer.parseInt(input1[1]);

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        recursion(0, n / 2, 0);
        isLeft = 0;
        recursion(n / 2, n, 0);

        if (s == 0) ans--;
        System.out.println(ans);
    }
}
