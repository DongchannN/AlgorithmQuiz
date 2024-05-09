package greedy;

import java.io.*;

public class Boj_1083 {
    static int[] arr;

    static int findNextMaxPtr(int s, int e) {
        int maxPtr = s;
        for (int i = s; i < e; i++) {
            if (arr[i] > arr[maxPtr]) {
                maxPtr = i;
            }
        }
        return maxPtr;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int s = Integer.parseInt(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        int ptr = 0;
        int maxPtr = findNextMaxPtr(ptr, n);
        while (ptr < n) {
            if (s <= 0) {
                break;
            }
            if (maxPtr == ptr) {
                ptr++;
                maxPtr = findNextMaxPtr(ptr, n);
                continue;
            }
            int dist = maxPtr - ptr;
            if (dist > s) {
                maxPtr = findNextMaxPtr(ptr, maxPtr);
            } else {
                int temp = arr[maxPtr];
                for (int i = maxPtr; i > ptr; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[ptr] = temp;
                s -= (maxPtr - ptr);
                ptr++;
                maxPtr = findNextMaxPtr(ptr, n);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
