package binarySearch;

import java.util.*;
import java.io.*;

public class Boj_1920 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] ss = br.readLine().split(" ");
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(ss[i]);
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        String[] compare = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(compare[i]);
            if (Arrays.binarySearch(arr, num) >= 0)
                System.out.println(1);
            else System.out.println(0);
        }


    }
}
