package binarySearch;

import java.io.*;
import java.util.*;

public class Boj_2470 {
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(s[i]);
        Arrays.sort(arr);

        int ansAbs = 2_000_000_001;
        int ans1 = 0;
        int ans2 = 0;
        for (int i = 0; i < n - 1; i++) {
            int res = findOptimalNumber(arr, i + 1, n - 1, arr[i]);
            System.out.println("res = " + res);
            int abs = Math.abs(arr[i] + res);
            if (abs < ansAbs) {
                ansAbs = abs;
                ans1 = arr[i];
                ans2 = res;
            }
        }

        System.out.printf("%d %d\n", ans1, ans2);
    }

    int findOptimalNumber(Integer[] arr, int startIdx, int lastIdx, int num) {
        int s = startIdx;
        int l = lastIdx;
        int ret = arr[(s + l) / 2];

        while (s <= l) {
            int m = (s + l) / 2;
            int sum = num + arr[m];
            if (Math.abs(sum) < Math.abs(num + ret))
                ret = arr[m];
            if (sum < 0)
                s = m + 1;
            else if (sum > 0)
                l = m - 1;
            else return arr[m];
        }
        return ret;
    }
}
