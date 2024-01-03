package binarySearch;

import java.io.*;
import java.util.Arrays;

public class Boj_10816 {

    int findLowerBoundIdx (Integer[] arr, int num) {
        int rtn = arr.length;
        int s = 0;
        int l = arr.length - 1;
        while (s <= l) {
            int m = (s + l) / 2;
            if (arr[m] < num) {
                s = m + 1;
            } else {
                l = m - 1;
                rtn = m;
            }
        }
        return rtn;
    }

    int findUpperBoundIdx (Integer[] arr, int num) {
        int rtn = arr.length;
        int s = 0;
        int l = arr.length - 1;
        while (s <= l) {
            int m = (s + l) / 2;
            if (arr[m] <= num) {
                s = m + 1;
            } else {
                l = m - 1;
                rtn = m;
            }
        }
        return rtn;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        String[] s2 = br.readLine().split(" ");

        Integer[] arr = new Integer[n];
        Integer[] toSearch = new Integer[m];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(s[i]);
        for (int i = 0; i < m; i++)
            toSearch[i] = Integer.parseInt(s2[i]);
        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            int lb = findLowerBoundIdx(arr, toSearch[i]);
            int ub = findUpperBoundIdx(arr, toSearch[i]);
            bw.write(ub - lb + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
