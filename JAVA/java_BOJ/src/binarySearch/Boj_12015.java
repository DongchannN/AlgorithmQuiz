package binarySearch;

import java.io.*;

public class Boj_12015 {
    static int n;
    static int[] arr;
    static int[] partialArr;

    static void replaceClosestValue(int replace, int size) {
        int l = 0;
        int r = size;
        int replacedIdx = (l + r) / 2;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (partialArr[mid] < replace)
                l = mid + 1;
            else {
                replacedIdx = mid;
                r = mid - 1;
            }
        }
        partialArr[replacedIdx] = replace;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");

        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(strArr[i]);

        partialArr = new int[n];
        partialArr[0] = arr[0];
        int size = 1;
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (num > partialArr[size - 1]) {
                partialArr[size++] = num;
            } else if (num < partialArr[size - 1]) {
                replaceClosestValue(num, size);
            }
        }
        System.out.println(size);
    }
}
