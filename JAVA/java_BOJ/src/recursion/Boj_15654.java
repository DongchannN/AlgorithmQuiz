package recursion;

import java.io.*;
import java.util.*;

public class Boj_15654 {

    static int[] arr;
    int m;

    void printArr(int[] print, int cnt, int beforeIdx) {
        if (cnt == m) {
            for (int i : print)
                System.out.printf("%d ", i);
            System.out.println();
            return ;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        String[] strArr = br.readLine().split(" ");
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(strArr[i]);

        Arrays.sort(arr);
        int[] print = new int[n];
        printArr(print, 0, 0);
    }
}
