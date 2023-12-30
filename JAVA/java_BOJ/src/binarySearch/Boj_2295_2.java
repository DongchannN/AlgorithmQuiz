package binarySearch;

import java.util.*;
import java.io.*;

/**
 * Solve by Using Set
 */
public class Boj_2295_2 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Set<Integer> sumSet = new HashSet<>();
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                sumSet.add(arr[i] + arr[j]); // X + Y

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sub = arr[i] - arr[j]; // K - Z;
                if (sumSet.contains(sub))
                    ans = Math.max(ans, arr[i]);
            }
        }
        System.out.println(ans);
    }
}
