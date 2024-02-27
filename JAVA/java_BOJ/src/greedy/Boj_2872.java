package greedy;

import java.io.*;

public class Boj_2872 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > max) {
                max = arr[i];
                maxIdx = i;
            }
        }

        int len = 0;
        for (int i = maxIdx; i >= 0; i--) {
            if (arr[i] == max) {
                max--;
                len++;
            }
        }
        System.out.println(n - len);
    }
}
