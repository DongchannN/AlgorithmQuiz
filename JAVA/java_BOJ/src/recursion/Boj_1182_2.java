package recursion;

import java.util.*;
import java.io.*;

public class Boj_1182_2 {

    static int cnt;
    static int[] arr;
    static int s;

    static void recursion(int idx, int sum) {
        if (idx == arr.length) return ;
        if (sum + arr[idx] == s) cnt++;

        recursion(idx + 1, sum + arr[idx]);
        recursion(idx + 1, sum);
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");

        int n = Integer.parseInt(input1[0]);
        s = Integer.parseInt(input1[1]);

        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(input2[i]);


        cnt = 0;
        recursion(0, 0);
        System.out.println(cnt);
    }
}
