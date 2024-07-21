package greedy;

import java.io.*;
import java.util.*;

public class Boj_1715 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (Integer num : arr)
            heap.offer(num);
        int ans = 0;
        while (heap.size() >= 2) {
            int sum = heap.poll() + heap.poll();
            ans += sum;
            heap.offer(sum);
        }
        System.out.println(ans);
    }
}
