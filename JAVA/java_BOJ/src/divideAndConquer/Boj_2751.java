package divideAndConquer;

import java.io.*;
import java.util.*;

public class Boj_2751 {

    int[] arr;
    int[] sorted;

    void combine(int start, int end) {
        int mid = (start + end) / 2;
        int l = start;
        int r = mid + 1;

        int idx = start;
        while (l <= mid && r <= end) {
            if (arr[l] < arr[r])
                sorted[idx] = arr[l++];
            else
                sorted[idx] = arr[r++];
            idx++;
        }

        while (l <= mid)
            sorted[idx++] = arr[l++];

        while (r <= end)
            sorted[idx++] = arr[r++];

        for (int i = start; i <= end; i++)
            arr[i] = sorted[i];
    }

    void divide(int start, int end) {
        if (start == end) return;
        int mid = (start + end) / 2;
        divide(start, mid);
        divide(mid + 1, end);
        combine(start, end);
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        sorted = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        divide(0, n - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(arr[i] + "\n");
        System.out.println(sb.toString());
    }
}
