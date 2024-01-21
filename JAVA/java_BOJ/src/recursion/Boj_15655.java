package recursion;

import java.io.*;
import java.util.*;

public class Boj_15655 {

    int n, m;
    static int[] arr;
    static int[] print;
    static boolean[] visited;

    void printArr(int depth, int idx) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i : print)
                sb.append(i + " ");
            System.out.println(sb.toString());
            return ;
        }

        for (int i = idx; i < n; i++) {
            print[depth] = arr[i];
            printArr(depth + 1, i + 1);
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        String[] strArr = br.readLine().split(" ");
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(strArr[i]);

        Arrays.sort(arr);
        print = new int[m];
        printArr(0, 0);
    }
}
