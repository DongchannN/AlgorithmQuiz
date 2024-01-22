package recursion;

import java.io.*;
import java.util.*;

public class Boj_15654 {

    static int[] arr;
    static int[] print;
    static boolean[] visited;
    int m;
    int n;

    void printArr(int printIdx) {
        if (printIdx == m) {
            StringBuilder sb = new StringBuilder();
            for (int i : print)
                sb.append(i + " ");
            System.out.println(sb.toString());
            return ;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                print[printIdx] = arr[i];
                printArr(printIdx + 1);
                visited[i] = false;
            }
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
        visited = new boolean[n];
        printArr(0);
    }
}
