package twoPointer;

import java.io.*;
import java.util.*;

public class Boj_2230 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int ans = arr[n - 1] - arr[0];
        int p2 = 0;
        for (int p1 = 0; p1 < n; p1++) {
            while (p2 < n - 1 && p1 <= p2) {
                int sub = arr[p2] - arr[p1];
                if (sub < m) {
                    p2++;
                } else {
                    ans = Math.min(ans, sub);
                    break;
                }
            }
            if (p2 == n - 1) {
                int sub = arr[p2] - arr[p1];
                if (sub >= m) ans = Math.min(ans, sub);
            }
        }
        System.out.println(ans);
    }
}
